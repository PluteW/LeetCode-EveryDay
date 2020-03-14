package LeetCode.PunchTheClock;

import java.util.Arrays;

public class LC300_zuichangshangshengzixulie_200314 {

    public static void main(String[] args) {

    }

    /**
     * @Description：  动态规划 结合 二分查找算法
     * @Params:     int[] nums 目标数组
     * @return:     int len  最大上升子序列长度
     * @author: Mr.Wang
     * @create: 22:53
    */
    public int solution(){
        int[] nums = {10,9,2,5,3,7,101,18};
        if (nums.length<=1){
            return nums.length;
        }
        int len = 1;
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            int left = 0;
            int right = len;
            while (left < right){
                int mid = left+(right-left)/2;
                if (nums[i] > temp[mid]){
                    left = mid+1;
                }else {
                    right = mid;
                }
            }
            temp[left] = nums[i];
            if (left == len)
                len++;
        }
        return len;
    }

    public int solution2(){
        int[] nums = {10,9,2,5,3,7,101,18};
        if (nums.length<=1){
            return nums.length;
        }
        int[] temp = new int[nums.length];
        int ret = 1;
        Arrays.fill(temp,1);
        for (int i = 1;i<nums.length;i++) {
            for (int j = 0;j<i;j++){
                if (nums[j] < nums[i]){
                    temp[i] = Math.max(temp[i],temp[j]+1);
                }
            }
            ret = Math.max(temp[i],ret);
        }
        return ret;
    }

}
