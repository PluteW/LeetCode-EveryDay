package LeetCode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102_erchashucengcibianli_200314 {

    public static void main(String[] args) {
        LC102_erchashucengcibianli_200314 Solution = new LC102_erchashucengcibianli_200314();
        TreeNode root = Solution.new TreeNode(5);
        List<List<Integer>> ret = Solution.levelOrder(root);
        System.out.println(ret);
    }
    /**
     * @Description：    迭代算法
     *      将当代的节点保存在 queue 中，先将本代的数字压入链表中
     *      而后将当代的节点的子节点逐个压入到新的队列中
     * @Params:     TreeNode root  需要进行分层输出的树的根节点
     * @return:     List<List<Integer>>  ret  分层循环输出的结果链表
     * @author: Mr.Wang
     * @create: 23:35
    */

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ret = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            Queue<TreeNode> q = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode t = queue.poll();
                if (t != null){
                    temp.add(t.val);
                    q.offer(t.left);
                    q.offer(t.right);
                }
            }
            if (!temp.isEmpty())
                ret.add(temp);
            queue = q;
        }
        return ret;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
