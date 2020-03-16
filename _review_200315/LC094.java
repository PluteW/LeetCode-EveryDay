package LeetCode._review_200315;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode temp = root;
        while (temp != null || !stack.isEmpty()){
            while (temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        return list;
    }
    public List<Integer> inorderTraversal1(TreeNode root) {
        if (root == null) return new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new LinkedList<>();
        TreeNode treeNode = root;
        while (treeNode!=null || !stack.isEmpty()){
            while (treeNode!=null){
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.pop();
            list.add(treeNode.val);
            treeNode = treeNode.right;
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
