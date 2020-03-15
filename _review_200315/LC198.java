package LeetCode._review_200315;

public class LC198 {

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] ret = new int[nums.length];
        ret[0] = nums[0];
        ret[1] = Math.max(nums[0],nums[1]);
        for (int i = 2;i<nums.length;i++){
            ret[i] = Math.max(nums[i]+ret[i-2],ret[i-1]);
        }
        return ret[nums.length-1];
    }
    public int rob1(int[] nums) {
        int preMax = 0;
        int curMax = 0;
        for (int num : nums){
            int temp = curMax;
            curMax = Math.max(preMax+num,curMax);
            preMax = temp;
        }
        return curMax;
    }
}
