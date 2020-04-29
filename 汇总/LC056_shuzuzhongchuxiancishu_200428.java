package LeetCode.汇总;

import java.util.HashSet;
import java.util.Set;

public class LC056_shuzuzhongchuxiancishu_200428 {
    public int[] singleNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums){
            if (set.contains(n))
                set.remove(n);
            else
                set.add(n);
        }
        Object[] ret = set.toArray();
        int[] reti = new int[ret.length];
        for (int i = 0;i<ret.length;i++)
            reti[i] = (int)ret[i];
        return reti;
    }

//    采用亦或运算
    public int[] singleNumbers2(int[] nums) {
        int sum = 0;
        int[] res = new int[2];
        for(int num : nums){
            sum ^= num;
        }
        int lowbit = sum & (-sum);
        for(int num : nums){
            if((num & lowbit) == 0){
                res[0] ^= num;
            }else{
                res[1] ^= num;
            }
        }
        return res;
    }
}
