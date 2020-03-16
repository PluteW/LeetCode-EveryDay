package LeetCode.Arithmetic.DFS;

import java.util.HashMap;

public class LC105_congqianxuzhongxugouzaoerchashu_200316 {


    int[] preorder;
    int[] inorder;
    int preIndex = 0;
    HashMap<Integer,Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length)
            return null;
        this.preorder = preorder;
        this.inorder = inorder;
        for (int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(0,inorder.length-1);
    }
    public TreeNode dfs(int start,int end){
        if (start>end) return null;

        TreeNode node = preorder
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
