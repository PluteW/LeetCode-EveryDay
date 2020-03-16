package LeetCode.Structure.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LC101_duichenerchashu_200314 {
    public static void main(String[] args) {
        LC101_duichenerchashu_200314 Solution = new LC101_duichenerchashu_200314();
        TreeNode root = Solution.new TreeNode(5);
        boolean ret = Solution.isSymmetric1(root);
        System.out.println(ret);
    }


    /**
     * @Description：  方法一： 借助递归算法  借助两个对称树的镜像关系来进行判断
     * @Params:     TreeNode root  待判别树的根节点
     * @return:     boolean ret 是够是对称树
     * @author: Mr.Wang
     * @create: 23:09
    */
    public boolean isSymmetric1(TreeNode root){
        return helper(root,root);
    }
    public boolean helper(TreeNode t1,TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val)
                && helper(t1.left,t2.right)
                && helper(t1.right,t2.left);
    }

    public boolean isSymmetricl2(TreeNode root){
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left == null || root.right == null) return false;
        Queue<TreeNode> left = new LinkedList<>();
        Queue<TreeNode> right = new LinkedList<>();
        left.offer(root.left);
        right.offer(root.right);
        while (!left.isEmpty()){
            TreeNode l = left.poll();
            TreeNode r = right.poll();
            if (l == null && r == null) continue;       // 这里只是局部的相等，整体的判断还没有结束，故应该continue
            if (l == null || r == null) return false;
            if (l.val != r.val) return false;
            left.offer(l.left);
            left.offer(l.right);
            right.offer(r.right);
            right.offer(r.left);
        }
        return true;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
