package LeetCode.汇总;

import java.util.Arrays;

public class LC300_zuichangshangxulie_200216 {

    public static void main(String args[]) {
        LC300_zuichangshangxulie_200216 Solution = new LC300_zuichangshangxulie_200216();
        int ret = Solution.solution2();
        System.out.println(ret);
    }

    /**
     *      方法一：动态规划
     *      循环至当前位置时，以当前数字为结尾的子串的长度，应为以前面较小数字为结尾子串长度+1
     * **/
    public int solution() {
        int[] nums = {10,9,2,5,3,7,101,18};

        if (nums.length <= 0) {
            return nums.length;
        }
        int ret  = 1;
        int t[] = new int[nums.length];
        Arrays.fill(t,1);
        for (int i = 1;i<nums.length;i++) {
            for (int j = 0;j<i;j++){
                if (nums[j] < nums[i]){
                    t[i] = Math.max(t[i],t[j]+1);
                }
            }
            ret = Math.max(t[i],ret);
        }
        return ret;
    }
/**
 *      方法二： 动态规划结合二分查找
 *      ret保存当前出现的最长子串长度
 *      取到一个值后，尝试用其换掉现有子串中，比它大的一个数字，使得之后更容易延长子串
 * */
    public int solution2(){
        int[] nums = {10,9,2,5,3,7,101,18};
        int len = nums.length;
        // 特判
        if (len <= 1) {
            return len;
        }
        int[] tail = new int[len];
        tail[0] = nums[0];
        int end = 0;
        for (int i = 1; i < len; i++) {
            int left = 0;
            int right = end + 1;
            while (left < right) {
                // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                // int mid = left + (right - left) / 2;
                int mid = (left + right) >>> 1;
                if (tail[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            // 因为 【逻辑 1】，因此一定能找到第 1 个大于等于 nums[i] 的元素
            // 因此，无需再单独判断，直接更新即可
            tail[left] = nums[i];
            // 但是 end 的值，需要更新，当前仅当更新位置在当前 end 的下一位
            if (left == end + 1) {
                end++;
            }
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }

}
