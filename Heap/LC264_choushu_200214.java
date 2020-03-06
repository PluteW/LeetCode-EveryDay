package LeetCode.Heap;

import java.util.PriorityQueue;

public class LC264_choushu_200214 {

    public static void main(String args[]) {
        LC264_choushu_200214 Solution = new LC264_choushu_200214();
        int ret = Solution.solution2();
        System.out.println(ret);
    }
/**
 *  任务目标，寻找第 n 个丑数（只能被 2 3 5 整除）
 *  方法一： 暴力法
 *  方法二： 小顶堆法
 *  方法三： 三指针法
 * **/
//  方法二： 小顶堆法
    public int solution() {
        int n = 10;
        double ret = 1;
        PriorityQueue<Double> q = new PriorityQueue<>();
        for (int i = 1;i<n;i++){
            q.add(2.0*ret);
            q.add(3.0*ret);
            q.add(5.0*ret);
            ret = q.peek();
            q.poll();
            while (!q.isEmpty()&&q.peek() == ret)       // 退出多余的重复的数值
                q.poll();
        }
        return (int)ret;
    }

    public int solution2() {
        int n = 10;
        double[] ret = new double[n];
        ret[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0;
        for (int i = 1;i<n;i++) {
            double min = Math.min(ret[i2]*2, Math.min(ret[i3]*3,ret[i5]*5));
            ret[i] = min;
//            下列写法不能够过滤掉重复数值
//            if (min == ret[i2]*2) i2++;
//            else if (min == ret[i3] *3) i3++;
//            else i5++;
            if (min == ret[i2] * 2) i2++;
            if (min == ret[i3] * 3) i3++;
            if (min == ret[i5] * 5) i5++;
        }
        return (int)ret[n-1];
    }


}
