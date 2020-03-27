package LeetCode.汇总;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC145_houxubianli_200316 {

    public static void main(String[] args) {

    }
    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<Integer> list = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            list.addFirst(treeNode.val);
            if (treeNode.left != null)
                stack.push(treeNode.left);
            if (treeNode.right != null)
                stack.push(treeNode.right);
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
