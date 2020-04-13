package LeetCode.汇总;

public class LC375_geweishuzibutonggeshu_200413 {

    
    /**
     * @Description： 计算N位数最多存在有多少个数字，每一位都不重复
     * @Params:     int n   生成的数字的位数
     * @return:     int sum     能生成的结果的数目
     * @author: Mr.Wang
     * @create: 23:21
    */
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        if(n==1) return 10;
        int [] dp=new int[n+1];//从下标1开始使用
        dp[1]=10;//一位数
        dp[2]=81;//两位数：9*9
        int sum=dp[1]+dp[2];
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]*(10-i+1);
            sum+=dp[i];
        }
        return sum;
    }
}
