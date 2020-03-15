package LeetCode._review_200315;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length<=1){
            return nums.length;
        }
        int[] ret = new int[nums.length];
        int len = 1;
        ret[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            int left = 0;
            int right = len;
            while (left < len){
                int mid = (left+right)/2;
                if (nums[i]>nums[mid])
                    left = mid+1;
                else
                    right = mid;
            }
            ret[left] = nums[i];
            if (left == len)
                len++;
        }
        return len;
    }
}
