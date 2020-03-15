package LeetCode._review_200315;

public class LC121 {
    public int maxProfit(int[] prices) {
        int minPrise = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for (int price : prices){
            if (price < minPrise)
                minPrise = price;
            maxProfit = Math.max(maxProfit,price - minPrise);
        }
        return maxProfit==Integer.MIN_VALUE?0:maxProfit;
    }
}
