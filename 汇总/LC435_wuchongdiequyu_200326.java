package LeetCode.汇总;

import java.util.Arrays;
import java.util.Comparator;

public class LC435_wuchongdiequyu_200326 {
    /**
     * @Description：    动态规划法
     *              首先将这个队列进行排序，优先按照起始点小的放到开始，
     *              起始点相同的两组数据，结束点小的往前放
     *              逐个往数轴上进行添加，记录在放置这个对象时最多可以放置多少个对象
     * @Params:     int[][] intervals  包含着不同起始位置的片段
     * @return:     int  ret  至少需要移除多少个小片段才能不重叠
     * @author:     Mr.Wang
     * @create:     23:39
    */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]!=o2[0]?o1[0]-o2[0]:o1[1]-o2[1];
            }
        });
        int dp[] = new int[intervals.length];
        dp[0] = 1;
        int ans = 1;
        for (int i = 1; i < dp.length; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (intervals[j][1]<=intervals[i][0]) {
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            ans = Math.max(ans, dp[i]);
        }
        return intervals.length - ans;
    }
}
