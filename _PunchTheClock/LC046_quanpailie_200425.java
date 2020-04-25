package LeetCode._PunchTheClock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC046_quanpailie_200425 {

    List<List<Integer>> ret = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {

        ArrayList temp = new ArrayList();
        for (int i = 0;i<nums.length;i++){
            temp.add(nums[i]);
        }
        helper(0,nums.length,temp);
        return ret;
    }


    public void helper(int begin,int length,ArrayList<Integer> temp){
        if (begin == length){
            ret.add(new ArrayList<>(temp));     //  这里需要new新的Collection进行保存，否则
            return;
        }
        for (int i = begin;i<length;i++){
            Collections.swap(temp,begin,i);
            helper(begin+1,length,temp);
            Collections.swap(temp,begin,i);
        }
    }

}
