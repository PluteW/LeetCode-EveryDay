package LeetCode.汇总;

public class LC122_maimaigupiao2_200321 {
    /**
     * @Description：  循环找波峰和波谷
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 22:11
    */
    public int maxProfit1(int[] prices) {
        if(prices.length == 0) return 0;
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int maxprofit = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            maxprofit += peak - valley;
        }
        return maxprofit;
    }
    public int maxProfit2(int[] prices) {
        if(prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1;i<prices.length;i++){
            if (prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }
}
