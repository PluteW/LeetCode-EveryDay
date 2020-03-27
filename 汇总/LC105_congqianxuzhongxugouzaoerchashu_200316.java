package LeetCode.汇总;

import java.util.HashMap;
import java.util.Map;

public class LC105_congqianxuzhongxugouzaoerchashu_200316 {


    int[] preorder;
    int[] inorder;
    int preIndex = 0;
    Map<Integer,Integer> map = new HashMap<>();

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
        int val = preorder[preIndex];
        TreeNode node = new TreeNode(val);
        int index = map.get(val);
        preIndex++;
        node.right = dfs(index+1,end);      // 这里先找右子树，再找左子树
        node.left = dfs(start,index-1);

        return node;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
