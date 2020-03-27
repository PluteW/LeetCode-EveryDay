package LeetCode.汇总;

import java.util.*;

public class LC347_qianKgaopinyuansu_200307 {

    public static void main(String[] args) {
        new LC347_qianKgaopinyuansu_200307().solution2();
    }

    /**
     * @Description：  先计数，然后将数字与次数一起保存到大顶堆中  -> 无法应对有负数出现的情况
     *                  -------》》》  解决方案： 使用 Map 来保存次数   《《《--------
     * @Params:     int[] nums 保存数字的原始数组    int k 需要返回的前 k 个数字
     * @return:     List<Intger> 保存着结果的 List
     * @author: Mr.Wang
     * @create: 23:27
    */
    public List<Integer> solution(){
        int[] nums = {1};
        int k = 1;
        int len = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a,b) -> (b[1]-a[1]));
        List<Integer> ret = new LinkedList<>();
        Arrays.sort(nums);
        int Max = Math.max(nums[len-1],len);
        int[] counter = new int[Max+1];
        for (int i:nums){
            counter[i]++;
        }
        for (int i = 1;i<Max+1;i++){
            if (counter[i] != 0)
                priorityQueue.offer(new int[]{i,counter[i]});
        }
        for (int i = 0;i<k;i++){
            ret.add(priorityQueue.poll()[0]);
        }
        return ret;
    }


    /**
     * @Description：  使用 Map 来保存次数，然后将数字与次数一起保存到大顶堆中  -> 无法应对有负数出现的情况
     * @Params:     int[] nums 保存数字的原始数组    int k 需要返回的前 k 个数字
     * @return:     List<Intger> 保存着结果的 List
     * @author: Mr.Wang
     * @create: 23:38
    */
    public List<Integer> solution2(){
        int[] nums = {1};
        int k = 1;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<int[]>((a,b) -> (b[1]-a[1]));
        List<Integer> ret = new LinkedList<>();
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0;i<nums.length;i++){
            if (!map.containsKey(nums[i]))
                map.put(nums[i],0);
            map.put(nums[i],map.get(nums[i])+1);
        }
        for (int key:map.keySet()){
            priorityQueue.offer(new int[]{key,map.get(key)});
        }
        for (int i = 0;i<k;i++){
            ret.add(priorityQueue.poll()[0]);
        }
        return ret;
    }
}
