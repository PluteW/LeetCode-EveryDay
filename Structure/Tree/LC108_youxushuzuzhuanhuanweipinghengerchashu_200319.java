package LeetCode.Structure.Tree;


public class LC108_youxushuzuzhuanhuanweipinghengerchashu_200319 {

    /**
     * @Description：    深度优先算法  DFS
     * @Params:   int[] nums  待建树的数组
     * @return:   TreeNode  root  二叉搜索树的根节点
     * @author: Mr.Wang
     * @create: 21:46
    */
    int[] nums;
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);
    }
    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        int p = (left + right) / 2;
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
