package LeetCode._review_200315;

public class LC053 {

    public int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int Max = nums[0];
        for (int i = 1;i<nums.length;i++){
            currentMax = Math.max(currentMax+nums[i],nums[i]);
            Max = Math.max(currentMax,Max);
        }
        return Max;
    }
}
