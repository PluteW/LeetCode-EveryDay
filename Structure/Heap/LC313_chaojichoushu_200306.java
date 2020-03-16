package LeetCode.Structure.Heap;

import java.util.PriorityQueue;

public class LC313_chaojichoushu_200306 {
    public static void main(String[] args) {

    }

    /**
     * @Description：  采用小顶堆的求解方法   这里使用double来存储运行数据（ 测试用例较大 ）
     * @Params:  int n 第几个超级丑数  int[] prime 因子列表
     * @return:  int ret 第 n 大的超级丑数
     * @author: Mr.Wang
     * @create: 23:23
    */
    public int solution(){
        int n = 12;
        int[] primes = {2,7,13,19};
        PriorityQueue<Double> queue = new PriorityQueue<Double>();
        queue.add(1.0);
        double ret = 1.0;
        for (int i=0;i<n;i++){
            for (int j:primes){
                queue.add(j*ret);
            }
            ret = queue.peek();
            while (!queue.isEmpty()&&queue.peek() == ret)
                queue.poll();
        }
        return (int)ret;
    }

    /**
     * @Description：  采用多指针法
     * @Params:  int n 第几个超级丑数  int[] prime 因子列表
     * @return:  int ret 第 n 大的超级丑数
     * @author: Mr.Wang
     * @create: 23:32
    */
    public int solution2(){
        int n = 12;
        int[] primes = {2,7,13,19};
        int[] dp = new int[n];
        dp[0] = 1;

        int k = primes.length;
        int[] index = new int[k];       // 用于保存各个因子的下标的数组

        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                if (min > dp[index[j]] * primes[j]) {       // 更新最小值
                    min = dp[index[j]] * primes[j];
                }
                dp[i] = min;
            }
            for (int j = 0; j < k; j++) {                   // 更新下标变量
                if (min == dp[index[j]] * primes[j]) {
                    index[j]++;
                }
            }
        }
        return dp[n - 1];


    }

}
