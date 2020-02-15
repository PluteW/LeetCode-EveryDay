package LeetCode.DP;

public class LC053_zuidazishuhe_200203 {

    public static void main(String args[]) {

        LC053_zuidazishuhe_200203 Solution = new LC053_zuidazishuhe_200203();
        int ret = Solution.solution();
        System.out.println(ret);

    }


    public int solution() {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int currSum = nums[0];
        int maxSum = nums[0];
        for (int i  = 1; i<nums.length;i++) {
            currSum = Math.max(nums[i], currSum+nums[i]);
            maxSum = Math.max(maxSum,currSum);
        }
        return maxSum;
    }

}
