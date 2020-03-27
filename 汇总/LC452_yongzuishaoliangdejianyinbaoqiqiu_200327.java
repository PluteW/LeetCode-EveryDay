package LeetCode.汇总;

import java.util.Arrays;
import java.util.Comparator;

public class LC452_yongzuishaoliangdejianyinbaoqiqiu_200327 {
    /**
     * @Description：  贪心算法
     *          开始就一支箭，判断下一个气球在不在这个范围内，在就继续，
     *          不在这个范围内，那就必须得增加一支箭，然后更新范围
     *          在进行判断之前需要根据结束的前后进行排序才行
     * @Params:     intp[][] points  气球的前后坐标
     * @return:     int arrows  需要的箭的数量
     * @author: Mr.Wang
     * @create: 22:42
    */
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int arrows = 1;
        int xStart, xEnd, firstEnd = points[0][1];
        for (int[] p : points) {
            xStart = p[0];
            xEnd = p[1];
            // if the current balloon starts after the end of another one,
            // one needs one more arrow
            if (firstEnd < xStart) {
                arrows++;
                firstEnd = xEnd;
            }
        }

        return arrows;
    }
}
