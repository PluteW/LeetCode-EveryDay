package LeetCode._test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class aboutComparator_200305 {

    /**
     * @Description： 搞清楚Comparator这个函数在进行排序中的作用
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 23:04
    */
    public static void main(String[] args) {
//        原始数组
        int[] nums = {1,2,5,6,8,3,4,2};

//        前者减后者，实现升序排列  小顶堆
        System.out.println("(n1,n2) -> n1- n2: ");
        PriorityQueue<Integer> heap1 = new PriorityQueue<>(((n1,n2) -> n1- n2));
        addAll(heap1,nums);
        print(heap1);
//        1 2 2 3 4 5 6 8

//        后者减去前者，实现降序排列  大顶堆
        System.out.println("(n1,n2) -> n2-n1: ");
        PriorityQueue<Integer> heap2 = new PriorityQueue<>(((n1,n2) -> n2-n1));
        addAll(heap2,nums);
        print(heap2);
//        8 6 5 4 3 2 2 1
        
    }
    public static void addAll(PriorityQueue<Integer> heap,int[] nums){
        for (int i = 0;i<nums.length;i++){
            heap.add(nums[i]);
        }
    }
    public static void print(PriorityQueue<Integer> heap){
        while (!heap.isEmpty()){
            System.out.print(heap.poll()+" ");
        }
        System.out.println();
    }
}
