package LeetCode._PunchTheClock;

public class LC053_zuidazixuhe_200503 {

    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentMax = nums[0];

        for (int i = 1;i<nums.length;i++){
            currentMax = Math.max(currentMax+nums[i],nums[i]);
            max = Math.max(max,currentMax);
        }
        return max;
    }

}
