package LeetCode._PunchTheClock;

public class LC543_erchashuzhijing_200310 {
    public static void main(String[] args) {

    }
    /**
     * @Description： 深度优先算法
     *              取根节点为深度 0 ，总长度为左侧长度L + 右侧长度R
     * @Params:     TreeNode root 根节点
     * @return:     int ans     最大总长
     * @author: Mr.Wang
     * @create: 22:24
    */
    int ans = 0;
    public int solution(TreeNode root){
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode node){
        if (node == null) return 0;
        int L = dfs(node.left);
        int R = dfs(node.right);
        ans = Math.max(ans,L+R);
        return Math.max(L,R)+1;
    }
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
