package LeetCode.Structure.Tree;

public class LC100_xaingtoudeshu_200313 {
    public static void main(String[] args) {
        LC100_xaingtoudeshu_200313 Solution = new LC100_xaingtoudeshu_200313();
        TreeNode p = Solution.new TreeNode(5);
        TreeNode q = Solution.new TreeNode(6);
        boolean ret = Solution.isSameTree(p,q);
        System.out.println(ret);
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        // one of p and q is null
        if (q == null || p == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.right, q.right) &&
                isSameTree(p.left, q.left);
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
