package LeetCode._PunchTheClock;

import java.util.LinkedList;
import java.util.List;

public class LC022_shengchengkuohao_200409 {

    public static void main(String[] args) {
        LC022_shengchengkuohao_200409 Solution = new LC022_shengchengkuohao_200409();
        int n = 3;
        Solution.generateParenthesis(n);
    }


    public List<String> generateParenthesis(int n) {
        List<String> ret = new LinkedList<>();
        int left = 0;
        int right = 0;
        String s = "";
        helper(n,left,right,s,ret);
        return ret;
    }
    public void helper(int n,int left,int right,String s,List<String> ret){
        if(left == right && left == n)
            ret.add(s.toString());
        if(left==right && left<n){
            helper(n,left+1,right,s+'(',ret);
        }
        if (left > right){
            if (left < n)
                helper(n,left+1,right,s+'(',ret);
            helper(n,left,right+1,s+')',ret);
        }
    }
}
