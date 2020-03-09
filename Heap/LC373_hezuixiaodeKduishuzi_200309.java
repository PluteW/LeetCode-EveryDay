package LeetCode.Heap;

import sun.plugin.javascript.navig.Link;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class LC373_hezuixiaodeKduishuzi_200309 {
    public static void main(String[] args) {
        new LC373_hezuixiaodeKduishuzi_200309().solution();
    }

    /**
     * @Description： 最小堆 + 穷举
     * @Params: int[] nums1  数字列表1  int[] nums2  数字列表2   int  k 需要返回的数字对数
     * @return: List<List<Integer>>  结果列表
     * @author: Mr.Wang
     * @create: 23:06
    */
    public List<List<Integer>> solution(){
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        LinkedList<List<Integer>> resList = new LinkedList<>();
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> twoSum(e2)-twoSum(e1));   // 维护一个大顶堆，方便及时弹出和大的数

        for (int n1 : nums1)
            for (int n2 : nums2) {
                int[] arr = new int[] {n1, n2};
                pQ.add(arr);
                if (pQ.size() > k)
                    pQ.poll();
            }

        while (!pQ.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int[] arr = pQ.poll();
            list.add(arr[0]);
            list.add(arr[1]);
            resList.add(list);
        }
        return resList;
    }

    public List<List<Integer>> solution2(){
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        LinkedList<List<Integer>> resList = new LinkedList<>();
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> twoSum(e2)-twoSum(e1));       // 维护一个大顶堆，方便及时弹出和大的数

        for (int n1 : nums1)
            for (int n2 : nums2) {
                int[] arr = new int[] {n1, n2};
                if (pQ.size() < k)
                    pQ.add(arr);
                else if (pQ.size() >= k  && twoSum(arr) < twoSum(pQ.peek())) { //剪枝
                    pQ.poll();
                    pQ.add(arr);
                }
            }

        while (!pQ.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int[] arr = pQ.poll();
            list.add(arr[0]);
            list.add(arr[1]);
            resList.add(list);
        }
        return resList;
    }

    public List<List<Integer>> solution3(){
        int[] nums1 = {1,7,11};
        int[] nums2 = {2,4,6};
        int k = 3;
        ArrayList<List<Integer>> resList = new ArrayList<>();
        PriorityQueue<int[]> pQ = new PriorityQueue<>((e1, e2) -> twoSum(e2)-twoSum(e1));
        int pre_n1 = 0x7fffffff;
        int pre_n2 = 0x7fffffff;

        for (int n1 : nums1)
            for (int n2 : nums2) {
                if (n1 > pre_n1 && n2 > pre_n2) {   //剪枝1
                    break;
                }
                int[] arr = new int[] {n1, n2};

                if (pQ.size() < k) {
                    pQ.add(arr);
                } else if (pQ.size() >= k && twoSum(arr) < twoSum(pQ.peek())) { //剪枝2
                    pQ.poll();
                    pQ.add(arr);
                    pre_n1 = n1;
                    pre_n2 = n2;
                }
            }

        while (!pQ.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            int[] arr = pQ.poll();
            list.add(arr[0]);
            list.add(arr[1]);
            resList.add(list);
        }
        return resList;
    }

    private int twoSum(int[] arr) {
        return arr[0] + arr[1];
    }
}
