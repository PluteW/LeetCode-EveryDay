package LeetCode.DP;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC279_wanquanpingfangshu_2002215 {

    public static void main(String args[]) {

        LC279_wanquanpingfangshu_2002215 Solution = new LC279_wanquanpingfangshu_2002215();
        int ret = Solution.solution2();
        System.out.println(ret);

    }

    /**
     * 首先假设，每个数字 n 都可以由 1 加和获取，1 的数量为数字本身
     * 设：
     *      最接近 n 的平方数的方根，也就是说，存在另一个 t ，使得：
     *          t + k*k == n ( n >=0 )
     *          此时， k*k 是 n 的一个子项，占据一个数量额度。
     *      可获得动态规划的状态转移方程为：
     *          f(n) = f(n-k*k) + 1
     * */
    public int solution() {
        int n = 13;

        int[] ret = new int[n+1];
        for (int i = 1;i<ret.length;i++) {
            ret[i] = i;
            for (int j = 1;i - j*j>=0;j++){
                ret[i] = Math.min(ret[i],ret[i-j*j]+1);
            }
        }
        return ret[n];
    }

    /**
     *  采广度优先的策略
     *  不管你是不是一个平方和，都从最小的平方和开始减去，然后压进队列
     *  考虑树的结构进行结合
     *  BFS三大要素：
     *      队列：先入先出的容器；
     *      出入队的节点；
     *      已访问集合：为了避免队列中插入重复的值
     * **/
    public int solution2(){
        int n = 13;
        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level=0;

        while(!queue.isEmpty()){
            level++;
            int len=queue.size();
            for(int i=0;i<len;i++){
                int cur=queue.poll();
                for(int j=1;j*j<=cur;j++){
                    int tmp=cur-j*j;
                    if(tmp==0)
                        return level;
                    if(!visited.contains(tmp))
                        queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }
        return level;
    }

}
