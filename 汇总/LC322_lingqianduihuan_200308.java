package LeetCode.汇总;

import java.util.Arrays;

public class LC322_lingqianduihuan_200308 {

    public static void main(String[] args) {
        LC322_lingqianduihuan_200308 Solution = new LC322_lingqianduihuan_200308();
        int ret = Solution.solution();
        System.out.println(ret);
    }

    /**
     * @Description： 单纯 DP ，针对人民币这种的问题有效，对于货币无特殊关系的无效，例如下面的金额数
     * @Params: int[] coins 可以使用的货币种类（各无限个） int amount 需要完成的目标的金额数
     * @return: int ret 需要的最少的硬币数目
     * @author: Mr.Wang
     * @create: 21:47
    */
    public int solution(){
        int[] coins = {186,419,83,408};
        int amount = 6249;
        int count = 0;
        Arrays.sort(coins);
        for (int i = coins.length-1;i>-1;i--){
            if (amount < coins[i]) continue;
            int temp = amount/coins[i];
            count += temp;
            amount -= temp*coins[i];
        }
        return amount == 0?count:-1;
    }


    /**
     * @Description：  方法二 ：深度优先算法 + 剪枝
     * @Params: int[] coins 可以使用的货币种类（各无限个） int amount 需要完成的目标的金额数
     * @return: int ret 需要的最少的硬币数目
     * @author: Mr.Wang
     * @create: 22:07
    */
    int ans=Integer.MAX_VALUE;
    public int solution2() {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        Arrays.sort(coins);
        dfs(coins,coins.length-1,amount,0);     // 从大额金额进行寻找
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    public void dfs(int[] coins,int index,int amount,int cnt){
        if(index<0){
            return;
        }
        for(int c=amount/coins[index];c>=0;c--){        // 从 最大金额的 最多使用数目开始凑数
            int na=amount-c*coins[index];               // 尝试使用当前的金额进行填满
            int ncnt=cnt+c;                             // 此时的尝试的数目
            if(na==0){                                  // 如果正好在此时凑出了金额
                ans=Math.min(ans,ncnt);                 // 保留当前的有效的最小硬币数
                break;//剪枝1
            }
            if(ncnt+1>=ans){                            // 如果此时的结果，再增加一个币都无法凑出，则一定不会是最优，剪枝
                break; //剪枝2
            }
            dfs(coins,index-1,na,ncnt);         // 如果在 n * 本金额 下没有合适的结果，那就继续寻找
        }
    }

    /**
     * @Description：    方法二 dfs + 剪枝 复现
     *  @Params: int[] coins 可以使用的货币种类（各无限个） int amount 需要完成的目标的金额数
     * @return: int ret 需要的最少的硬币数目
     * @author: Mr.Wang
     * @create: 22:24
    */
    public void search(int[] coins, int index, int amount, int count){
        if (index < 0) return;
        for (int i = amount/coins[index];i>-1;i--){
            int nowAmount = amount - coins[index] * i;
            int nowCount = i + count;
            if (nowAmount == 0){
                ans = Math.min(ans,nowCount);
                break;
            }else if (nowCount + 1 >= ans){
                break;
            }
            search(coins,index-1,nowAmount,nowCount);
        }
    }

    /**
     * @Description： 动态规划 - 自上而下 （ 性能不如深度优先算法 ）
     *          判断好拆解条件：    F（S） = F（S - Ci） +1 ；
     *          判断结束条件：     F(S)=0 ,when S=0
     *                             F(S)=−1 ,when n=0
     * @Params: int[] coins 可以使用的货币种类（各无限个） int amount 需要完成的目标的金额数
     * @return: int ret 需要的最少的硬币数目
     * @author: Mr.Wang
     * @create: 22:27
    */
    public int solution3() {
        int[] coins = {186,419,83,408};
        int amount = 6249;
        if (amount < 1) return 0;
        return coinChange(coins, amount, new int[amount]);
    }
    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) return -1;
        if (rem == 0) return 0;
        if (count[rem - 1] != 0) return count[rem - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min)
                min = 1 + res;
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
