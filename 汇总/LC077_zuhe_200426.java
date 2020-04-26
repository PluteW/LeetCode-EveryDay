package LeetCode.汇总;

import java.util.LinkedList;
import java.util.List;

public class LC077_zuhe_200426 {

    private List<List<Integer>> ret = new LinkedList<>();
    private int n;
    private int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        helper(1,new LinkedList<Integer>());
        return ret;
    }
    public void helper(int start,LinkedList<Integer> temp){
        if (temp.size() == this.k) {
            ret.add(new LinkedList(temp));
            return;
        }
        for (int i = start;i <= this.n;i++){
            temp.add(i);
            helper(i+1,temp);
            temp.removeLast();
        }
    }
}