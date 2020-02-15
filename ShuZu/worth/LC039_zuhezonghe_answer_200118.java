package LeetCode.ShuZu.worth;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC039_zuhezonghe_answer_200118 {
    private List ret = new ArrayList();
    private int length;
    private int[] candidates;

    public static void main(String args[]) {

        int[] candidates = new int[]{2,3,6,7};
        int target = 7;
        LC039_zuhezonghe_answer_200118 solution = new LC039_zuhezonghe_answer_200118();
        List ret = solution.solution(candidates,target);

        System.out.println(ret);
    }

    public List solution(int[] candidates, int target) {

        int length = candidates.length;
        if (length == 0){
            return ret;
        }
        this.length = length;
        this.candidates = candidates;

        Stack tem = new Stack();
        findSum(target,tem,0);
        return ret;
    }
    public void findSum(int residue, Stack tem, int start) {
        if (residue == 0){
            // Java 中可变对象是引用传递，因此需要将当前 path 里的值拷贝出来
            this.ret.add(new ArrayList<>(tem));
            return;
        }
        for (int i = start; i< length&& residue-candidates[i]>=0;i++){
            tem.push(candidates[i]);
            findSum(residue-candidates[i],tem,i);
            tem.pop();
        }
    }
}
