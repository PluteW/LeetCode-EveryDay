package LeetCode.Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC103_erchashudejuchixingcengcibianli_200314 {

    public static void main(String[] args) {
        LC103_erchashudejuchixingcengcibianli_200314 Solution  = new LC103_erchashudejuchixingcengcibianli_200314();
        TreeNode root = Solution.new TreeNode(5);
        List<List<Integer>> ret = Solution.zigzagLevelOrder(root);
        System.out.println(ret);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<List<Integer>> ret = new LinkedList<>();
        queue.add(root);
        boolean b = false;
        while (!queue.isEmpty()){
            LinkedList<TreeNode> q = new LinkedList<>();
            List<Integer> temp = new LinkedList<>();
            while (!queue.isEmpty()){
                TreeNode t = queue.pollFirst();
                if (t != null){
                    temp.add(t.val);
                    if (b){
                        q.addLast(t.left);
                        q.addLast(t.right);
                    }else {
                        q.addFirst(t.left);
                        q.addFirst(t.right);

                    }
                }
            }
            b = !b;
            if (!temp.isEmpty())
                ret.add(temp);
            queue = q;
        }
        return ret;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
