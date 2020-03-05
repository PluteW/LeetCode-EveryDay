package LeetCode.Heap;

import java.util.PriorityQueue;

public class LC215_diKdadeshu_200305 {

    public static void main(String[] args) {

    }
    /**
     * @Description： 借助一个小顶堆来保存前 K 大的元素，最后直接 pop 结果即可
     * @Params: int[] nums 保存着所有元素的数组   int k 要输出的第 k 大的数字
     * @return:
     * @author: Mr.Wang
     * @create: 22:59
    */
    public int solution(){
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        PriorityQueue<Integer> heap =
                new PriorityQueue<Integer>((n1, n2) -> n1 - n2);

        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }
        return heap.poll();
    }
}
