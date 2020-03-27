package LeetCode.汇总;

import java.util.Arrays;

public class LC135_fenfatangguo_200325 {
    /**
     * @Description： 贪心算法
     *      先给每一个孩子一个糖果
     *      然后逐个去判断是不是符合题意
     *      只要存在不符合的状况，则需要进行进一步的检查
     * @Params:     int[] rationgs 给孩子们的打分状况
     * @return:     int sum 所需要的最少的糖果数量
     * @author:     Mr.Wang
     * @create:     22:30
    */
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        boolean flag = true;
        int sum = 0;
        while (flag) {
            flag = false;
            for (int i = 0; i < ratings.length; i++) {
                if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                    candies[i] = candies[i + 1] + 1;
                    flag = true;
                }
                if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                    candies[i] = candies[i - 1] + 1;
                    flag = true;
                }
            }
        }
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
