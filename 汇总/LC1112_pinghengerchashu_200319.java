package LeetCode.汇总;

public class LC1112_pinghengerchashu_200319 {

    /**
     * @Description：
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 22:42
    */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = helper(root.left,0);
        int right = helper(root.right,0);
        return Math.abs((left - right))<=1?true:false;
    }
    public int helper(TreeNode root,int height){
        if(root == null) return height;
        else
            return Math.max(helper(root.left,height+1),helper(root.right,height+1));
    }

    /**
     * @Description：
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 22:42
    */

    private int height(TreeNode root) {
        // An empty tree has height -1
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(height(root.left) - height(root.right)) < 2
                && isBalanced2(root.left)
                && isBalanced2(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
