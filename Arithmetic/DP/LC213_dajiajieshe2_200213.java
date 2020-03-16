package LeetCode.Arithmetic.DP;

import java.util.Arrays;

public class LC213_dajiajieshe2_200213 {

    public static void main(String args[]) {
        LC213_dajiajieshe2_200213 Solution = new LC213_dajiajieshe2_200213();
        int ret = Solution.solution();
        System.out.println(ret);
    }

    public int solution(){
        int[] nums = {1,2,3,1};

        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(search(Arrays.copyOfRange(nums, 0, nums.length - 1)),
                search(Arrays.copyOfRange(nums, 1, nums.length)));
    }
    public int search(int[] nums){
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }
        int[] ans = new int[nums.length];
        ans[0] = nums[0];
        ans[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            ans[i] = Math.max(nums[i] + ans[i - 2], ans[i - 1]);
        }
        return ans[ans.length - 1];
    }

}
