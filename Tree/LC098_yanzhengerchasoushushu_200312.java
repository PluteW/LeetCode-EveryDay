package LeetCode.Tree;

import java.util.Stack;

public class LC098_yanzhengerchasoushushu_200312 {


    public static void main(String[] args) {
        LC098_yanzhengerchasoushushu_200312 Solution = new LC098_yanzhengerchasoushushu_200312();
        boolean ret = Solution.isValidBST(null);
        System.out.println(ret);
    }

    /**
     * @Description： 采用递归方法 
     * @Params:  TreeNode root 输入的根节点
     * @return:  boolean ret  是否为验证二叉树
     * @author: Mr.Wang
     * @create: 23:50
    */
    public boolean isValidBST(TreeNode root){
        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) return true;

        int val = node.val;
        if (lower != null && val <= lower) return false;
        if (upper != null && val >= upper) return false;

        if (! helper(node.right, val, upper)) return false;
        if (! helper(node.left, lower, val)) return false;
        return true;
    }

    /**
     * @Description：  采用中序输出的思路  从开始到结束，数列变化一定是增长
     * @Params:  TreeNode root 输入的根节点
     * @return:  boolean ret  是否为验证二叉树
     * @author: Mr.Wang
     * @create: 23:54
    */
    public boolean isValidBST2(TreeNode root){
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
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
