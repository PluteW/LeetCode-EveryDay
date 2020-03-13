package LeetCode.PunchTheClock;

import java.util.Arrays;

public class LC169_duoshuyuansu_200313 {
    public static void main(String[] args) {
        LC169_duoshuyuansu_200313 Solution = new LC169_duoshuyuansu_200313();
        int ret = Solution.solution1();
        System.out.println(ret);
    }
    /**
     * @Description： 方法一： 排序算法
     *              排序后，在中间的位置一定是众数
     * @Params: int[] nums 待寻找的数组
     * @return: int k  最多出现的数字
     * @author: Mr.Wang
     * @create: 22:23
    */
    public int solution1(){
        int[] nums = {2,2,1,1,1,2,2};
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * @Description： 方法二： 投票算法  ( 思路十分优美 )
     * @Params: int[] nums 待寻找的数组
     * @return: int k  最多出现的数字
     * @author: Mr.Wang
     * @create: 22:26
    */
    public int solution2(){
        int[] nums = {2,2,1,1,1,2,2};
        int moust = 0;
        int count = 0;
        for (int i : nums){
            if (count == 0)
                moust = i;
            count += (i == moust)?1:-1;
        }
        return moust;
    }

}
