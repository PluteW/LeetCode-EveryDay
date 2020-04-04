package LeetCode.汇总;

public class LC042_jieyushui_200404 {

    /**
     * @Description：  接雨水
     *          双指针法
     *              从两边开始同时遍历
     *              记录左侧最大和右侧最大
     *              较小的一方，累加水量，并向中间移动
     * @Params:     int[] height    记录高度的数组
     * @return:     int ans     留存的总水量
     * @author: Mr.Wang
     * @create: 22:00
    */

    public int trap(int[] height){
        int left = 0;
        int right = height.length-1;
        int left_max = 0,right_max = 0;
        int ans = 0;
        while(left<=right) {
            if (left_max < right_max) {
                ans += Math.max(0, left_max - height[left]);
                left_max = Math.max(left_max, height[left]);
                left += 1;
            } else {
                ans += Math.max(0, right_max - height[right]);
                right_max = Math.max(right_max, height[right]);
                right -= 1;
            }
        }
        return ans;
    }

}
