package LeetCode._PunchTheClock;

public class LC121_maimaigupiao_200309 {
    public static void main(String[] args) {

    }

    /**
     * @Description： 买卖股票获利最大
     *          当最低点处买入，之后不断更新最高点数据即可
     *          从左侧往右开始遍历，当最低值低于之前的最低值时，更新最低值
     *          用当前值与最低值进行作差，当差高于之前的最大值时，更新最大值
     * @Params:     int[] prices    保存价格变化的数组
     * @return:     int maxprifit   获取的最大利益
     * @author: Mr.Wang
     * @create: 22:19
    */
    public int solution(){
        int[] prices = {7,1,5,3,6,4};
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
}
