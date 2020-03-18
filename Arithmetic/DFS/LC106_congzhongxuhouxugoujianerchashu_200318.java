package LeetCode.Arithmetic.DFS;

import java.util.HashMap;

public class LC106_congzhongxuhouxugoujianerchashu_200318 {

    HashMap<Integer,Integer> map = new HashMap<>();
    int[] inorder;
    int[] postorder;
    int postIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        this.inorder = inorder;
        this.postorder = postorder;
        this.postIndex = postorder.length-1;
        for (int i = 0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return dfs(0,postIndex);
    }
    public TreeNode dfs(int start,int end){
        if (start > end) return null;
        int val = postorder[postIndex];
        TreeNode node = new TreeNode(val);
        postIndex--;
        int index = map.get(val);
        node.left = dfs(start,index-1);
        node.right = dfs(index+1,end);
        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
