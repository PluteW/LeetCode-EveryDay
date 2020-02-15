package LeetCode.ShuZu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class LC040_zuhezonghe2_200119 {


    public static void main(String args[]) {
        LC040_zuhezonghe2_200119 Solution = new LC040_zuhezonghe2_200119();
        List ret = Solution.solution();
        System.out.println(ret);
    }
    public List solution(){
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        List ret = new ArrayList();
        if (candidates.length == 0){
            return ret;
        }
        Arrays.sort(candidates);

        Stack temp = new Stack();
        findComplexSum(candidates,0, target, ret,temp);
        return ret;
    }
    public void findComplexSum(int[] candidates, int start, int residue, List ret, Stack temp) {

        if (residue == 0){
            ret.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i<candidates.length&& residue - candidates[i]>=0;i++) {
            if (i>start&&candidates[i] == candidates[i-1]) {
                continue;
            }
            temp.add(candidates[i]);
            findComplexSum(candidates,i+1,residue-candidates[i],ret,temp);
            temp.pop();
        }
    }
}
