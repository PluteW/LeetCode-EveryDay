package LeetCode.Structure.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LC094_zhongxulianli_200311 {
    public static void main(String[] args) {
        LC094_zhongxulianli_200311 Solution = new LC094_zhongxulianli_200311();
        List<Integer> ret = new LinkedList<>();
        System.out.println(ret);
    }
    /**
     * @Description： 借助递归算法实现
     * @Params: TreeNode root 树的根节点
     * @return: List<Integer> ret 保存结果的List列表
     * @author: Mr.Wang
     * @create: 22:45
    */
    public List<Integer> solution(){
        TreeNode root = new TreeNode(2);
        List<Integer> ret = new LinkedList<>();
        push(ret,root);
        return ret;
    }
    public void push(List<Integer> ret,TreeNode node){
        if (node == null) return;
        push(ret,node.left);
        ret.add(node.val);
        push(ret,node.right);
    }

    /**
     * @Description： 借助栈来实现  原理上与解法一相同
     * @Params: TreeNode root 树的根节点
     * @return: List<Integer> ret 保存结果的List列表
     * @author: Mr.Wang
     * @create: 22:51
    */
    public List<Integer> solution2() {
        TreeNode root = new TreeNode(2);
        List <Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack <> ();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            res.add(curr.val);
            curr = curr.right;
        }
        return res;
    }

    /**
     * @Description： 莫里斯遍历    将右子树逐步转移到下方去
     * @Params: TreeNode root 树的根节点
     * @return: List<Integer> ret 保存结果的List列表
     * @author: Mr.Wang
     * @create: 23:06
    */
    public List<Integer> solution3(){
        TreeNode root = new TreeNode(2);
        List <Integer> res = new ArrayList <> ();
        TreeNode curr = root;
        TreeNode pre;
        while (curr != null) {
            if (curr.left == null) {
                res.add(curr.val);
                curr = curr.right; // move to next right node
            } else { // has a left subtree
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                pre.right = curr; // put cur after the pre node
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null; // original cur left be null, avoid infinite loops
            }
        }
        return res;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
