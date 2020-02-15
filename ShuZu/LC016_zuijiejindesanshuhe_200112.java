package LeetCode.ShuZu;

import java.util.Arrays;

public class LC016_zuijiejindesanshuhe_200112 {


    public static void main(String args[]) {
        int ret = solution();
        System.out.println(ret);
    }

    public static int solution(){

        int[] nums = { 1,1,-1,-1,3};
        int target = -1;

        Arrays.sort(nums);
        int ret = nums[0] + nums[1] + nums[2];

        for (int i = 0;i<nums.length-2;i++){
            int l = i + 1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(ret - target)){
                    ret = sum;
                }
                if ( sum > target) {
                    r--;
                    while(r>i+1&&nums[r] == nums[r+1]) r--;
                } else {
                    l++;
                    while(l<nums.length-1&&nums[l+1] == nums[l]) l++;
                }
            }
        }
        return ret;
    }

}
