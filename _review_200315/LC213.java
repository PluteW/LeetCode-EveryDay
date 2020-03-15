package LeetCode._review_200315;

public class LC213 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(helper(nums,0,nums.length-1),helper(nums,1,nums.length));
    }
    public int helper(int[] nums, int start, int end){
        int preMax = 0;
        int currentMax = 0;
        for (int i = start;i<end;i++){
            int temp = currentMax;
            currentMax = Math.max(preMax + nums[i],currentMax);
            preMax = temp;
        }
        return currentMax;
    }
}
