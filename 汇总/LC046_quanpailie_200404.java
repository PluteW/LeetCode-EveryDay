package LeetCode.汇总;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LC046_quanpailie_200404 {

    /**
     * @Description：    全排列
     * @Params:     int[] nums  待排列数组
     * @return:     List<List<Integer>> ret 全排列的结果
     * @author: Mr.Wang
     * @create: 22:25
     */
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        List<List<Integer>> ret = new LinkedList<>();
        for (int n: nums)
            arrayList.add(n);
        helper(arrayList,ret,0);
        return ret;
    }
    public void helper(ArrayList<Integer> arrayList,List<List<Integer>> ret ,int first){
        if (first == arrayList.size()) ret.add(new ArrayList<Integer>(arrayList));
        for (int i = first;i<arrayList.size();i++){
            Collections.swap(arrayList,first,i);
            helper(arrayList,ret,first+1);
            Collections.swap(arrayList,first,i);
        }
    }
}
