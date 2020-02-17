package LeetCode.Sort;

import java.util.*;

public class LC056_hebingqujian_200217 {

    public static void main(String args[]){
        LC056_hebingqujian_200217 Solution = new LC056_hebingqujian_200217();
        int[][] ret = Solution.solution();
        System.out.println(ret);
    }

    public int[][] solution(){
        int[][] intervals = {
                {1,4},
                {0,6},
                {8,10},
                {15,18}};
        Integer[] indexArray = new Integer[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            indexArray[i] = i;
        }
        Arrays.sort(indexArray, Comparator.comparingInt(x ->intervals[x][0]));
        LinkedList<int[]> list = new LinkedList();
        for (int i : indexArray){
            if (list.isEmpty() || list.peekLast()[1]<intervals[i][0]){
                list.add(intervals[i]);
            }else {
                list.peekLast()[1] = Math.max(list.peekLast()[1],intervals[i][1]);
            }
        }
        int[][] ret = new int[list.size()][2];

        for (int i = 0;i<list.size();i++){
            ret[i] = list.get(i);
        }
        return ret;
    }

}
