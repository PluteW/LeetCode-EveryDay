package LeetCode.汇总;

public class LC1103_fentangguo_200305 {

    public static void main(String[] args) {

    }
    /**
     * @Description： 暴力求解法  直接在结果数列中进行遍历添加，还原发糖果的过程
     * @Params:  candies 糖果的总数    num_people  孩子的数目
     * @return:  保存着每个孩子拿到的糖果数量的数组
     * @author: Mr.Wang
     * @create: 22:21
    */
    public int[] solution(){
        int candies = 7;
        int num_people = 4;
        int[] ret = new int[num_people];
        int count = 0;
        int num = 1;
        while (count < candies){
            for (int i = 0;i<num_people;i++,num++){
                if (candies - count >= num){
                    ret[i] += num;
                    count += num;
                }else {
                    ret[i] += candies-count;
                    count = candies;
                }
            }
        }
        return ret;
    }

    /**
     * @Description：  官方的暴力求解法
     * @Params: candies 糖果的总数    num_people  孩子的数目
     * @return:  保存着每个孩子拿到的糖果数量的数组
     * @author: Mr.Wang
     * @create: 22:33
    */
    public int[] solution3(){
        int candies = 7;
        int num_people = 4;
        int n = num_people;
        int[] ans = new int[num_people];
        int i = 0;
        while (candies != 0) {
            ans[i % num_people] += Math.min(candies, i + 1);
            candies -= Math.min(candies, i + 1);
            i += 1;
        }
        return ans;
    }

    /**
     * @Description： 数学法，参考等差数列  一顿推导猛如虎
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 22:38
    */
    public int[] solution2(){
        int candies = 7;
        int num_people = 4;
        int n = num_people;
        // 计算出能够完整的分礼物多少次
        int p = (int)(Math.sqrt(2 * candies + 0.25) - 0.5);
        int remaining = (int)(candies - (p + 1) * p * 0.5);
        int rows = p / n, cols = p % n;

        int[] d = new int[n];
        for(int i = 0; i < n; ++i) {
            // 完整礼物分发的次数
            d[i] = (i + 1) * rows + (int)(rows * (rows - 1) * 0.5) * n;
            // 最后一轮礼物的分发过程
            if (i < cols) d[i] += i + 1 + rows * n;
        }
        // 剩下的糖果，直接给剩下的最后一个人
        d[cols] += remaining;
        return d;
    }

}
