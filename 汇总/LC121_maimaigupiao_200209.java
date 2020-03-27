package LeetCode.汇总;

public class LC121_maimaigupiao_200209 {

    public static void main(String args[]) {
        LC121_maimaigupiao_200209 Solution = new LC121_maimaigupiao_200209();
        int ret = Solution.solution();
        System.out.println(ret);
    }

    public int solution() {
        int[] prices = {7,1,5,3,6,4};

        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0;i<prices.length;i++){
            min_price = Math.min(min_price,prices[i]);
            max_profit = Math.max(prices[i]-min_price,max_profit);
        }
        return max_profit;
    }

}
