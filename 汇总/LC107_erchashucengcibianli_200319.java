package LeetCode.汇总;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC107_erchashucengcibianli_200319 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Deque<List<Integer>> ret = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Queue<TreeNode> q = new LinkedList<>();
            List<Integer> list = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left!=null) q.offer(treeNode.left);
                if (treeNode.right != null) q.offer(treeNode.right);
            }
            ret.offerFirst(list);
            queue = q;
        }
        return (List)ret;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
