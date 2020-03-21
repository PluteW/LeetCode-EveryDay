package LeetCode.Arithmetic.Greed;

public class LC055_tiaoyueyouxi_200321 {

    /**
     * @Description：  从后面往前面找，寻找好位置
     *          能到达末尾或者到达后面的好位置上的位置，均为“好位置
     * @Params:     int[]  nums  待判断的数组
     * @return:     boolean ret  开头能否到达结尾
     * @author: Mr.Wang
     * @create: 21:43
    */
    public boolean canJump1(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return true;
        nums[nums.length - 1] = -2;
        for (int i = nums.length - 2; i > -1; i--) {
            for (int j = 0; j <= nums[i] && i + j < nums.length; j++) {
                if (nums[i + j] == -2) {
                    nums[i] = -2;
                    continue;
                }
            }
        }
        return nums[0] == -2?true:false;
    }

    /**
     * @Description：  从最后一个元素开始遍历
     *                  及时更新需要到达的最小位置
     * @Params:     int[]  nums  待判断的数组
     * @return:     boolean ret  开头能否到达结尾
     * @author: Mr.Wang
     * @create: 21:50
    */
    public boolean canJump2(int[] nums){
        if (nums.length == 0 || nums.length == 1) return true;
        int minPosition = nums.length-1;
        for (int i = nums.length-2;i>-1;i--){
            if (nums[i]+i >= minPosition){
                minPosition = i;
            }
        }
        return minPosition == 0;
    }

}
