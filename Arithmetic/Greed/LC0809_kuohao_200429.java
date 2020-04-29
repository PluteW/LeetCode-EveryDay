package LeetCode.Arithmetic.Greed;

import java.util.LinkedList;
import java.util.List;

public class LC0809_kuohao_200429 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        helper(result,"",n,0,0);
        return result;
    }

    public void helper(List<String> resullt,String temp ,int n,int left,int right){
        if (left == n&& right == n){
            resullt.add(new String(temp));
        }
        if (left < n) {
            helper(resullt, temp + "(", n, left + 1, right);
        }
        if (right<left){
            helper(resullt,temp+")",n,left,right+1);
        }
    }
}
