package LeetCode.汇总;

import java.util.PriorityQueue;

public class LC040_zuixiaodeKgeshu_200320 {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a,b)->(b-a));
        for (int i : arr){
            priorityQueue.offer(i);
            if (priorityQueue.size()>k){
                priorityQueue.poll();
            }
        }
        int[] ret = new int[k];
        for (int i = 0;i<k;i++){
            ret[i] = priorityQueue.poll();
        }
        return ret;
    }
}
