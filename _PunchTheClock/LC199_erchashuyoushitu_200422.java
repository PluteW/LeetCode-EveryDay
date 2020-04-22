package LeetCode._PunchTheClock;

import java.util.*;

public class LC199_erchashuyoushitu_200422 {



    /**
     * @Description：  从二叉树的右侧看，输出看到的序列
     * @Params: TreeNode root  二叉树的根节点
     * @return: List<Integer> root  存储有结果的列表
     * @author: Mr.Wang
     * @create: 22:53
    */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (i == size - 1) {  //将当前层的最后一个节点放入结果列表
                    res.add(node.val);
                }
            }
        }
        return res;
    }


     public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
