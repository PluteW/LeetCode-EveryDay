package LeetCode.汇总;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC144_qianxubianli_200316 {
    public static void main(String[] args) {

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.add(treeNode.val);
            if (treeNode.right!= null)
                stack.push(treeNode.right);
            if (treeNode.left!=null)
                stack.push(treeNode.left);
        }
        return list;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
