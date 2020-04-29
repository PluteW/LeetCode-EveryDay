package LeetCode.Arithmetic.Greed;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LC0804_miji_200429 {
    /**
     * @Description：    借助掩码完成
     * @author: Mr.Wang
     * @create: 23:18
    */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
//        对于一个数字，要么选，要么不选，所以，总共是2^N种可能
        int bmp = (int) Math.pow(2, nums.length);
        // 从 nums.length 个 0 遍历到 nums.length 个 1
        for (int i = 0; i < bmp; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                // 将每一位右移最低位，检测其是否为1
                if ((i >>> j & 1) == 1) subset.add(nums[j]);
            subsets.add(subset);
        }
        return subsets;
    }

    /**
     * @Description：  采用逐个添加的思路
     * @author: Mr.Wang
     * @create: 23:37
    */
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (int i= 0;i<nums.length;i++){
            for (List<Integer> list : subsets){     // 报错：有同步问题
                if (list.size()<i+1){
                    list.add(nums[i]);
                    subsets.add(list);
                }
            }
        }
        return subsets;
    }
}
