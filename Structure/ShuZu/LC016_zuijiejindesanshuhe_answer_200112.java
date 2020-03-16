package LeetCode.Structure.ShuZu;

import java.util.Arrays;

public class LC016_zuijiejindesanshuhe_answer_200112 {


    public static void main(String args[]) {
        int ret = solution();
        System.out.println(ret);
    }

    public static int solution(){

        int[] nums = { 1,1,-1,-1,3};
        int target = -1;

        int answer = 0, rest = Integer.MAX_VALUE, absrest = Integer.MAX_VALUE;
        int minValue = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length-2; i++) {
            int k = nums.length - 1;
            int j = i + 1;
            while(k > j) {
                rest = target - (nums[i] + nums[j] + nums[k]);
                absrest = Math.abs(rest);
                if (absrest < minValue) {
                    minValue = absrest;
                    answer = nums[i] + nums[j] + nums[k];
                }
                if (rest >= 0) j++;
                else k--;
            }
            if (minValue == 0) return answer;           ///////////////极大地减少了时间复杂度
        }
        return answer;
    }
}
