package LeetCode.汇总;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LC406_shengaopaixu_200326 {
    /**
     * @Description：  借助List来进行排列
     *          优先按照身高进行排序（降序）
     *          身高相同的人，按照 k 值递增的顺序进行排列
     *          先将身高的高的人进行排序，然后将身高矮的人往里面插
     * @Params:  int[][] people  人员信息  people[0] 自己的身高  people[1] 前方升高≥自己身高的人数
     * @return:  int[][] output  保存有新顺序的数组
     * @author: Mr.Wang
     * @create: 22:57
    */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]==o2[0]?o1[1]-o2[1]:o2[0]-o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for (int[] p: people){
            output.add(p[1],p);
        }
        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}
