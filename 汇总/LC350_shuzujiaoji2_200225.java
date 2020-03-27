package LeetCode.汇总;

import java.util.Arrays;
import java.util.HashMap;

public class LC350_shuzujiaoji2_200225 {

    public static void main(String[] args) {
        LC350_shuzujiaoji2_200225 Solution = new LC350_shuzujiaoji2_200225();
        int[] ret = Solution.solution();
        for (int i =0;i<ret.length;i++){
            System.out.print(ret[i]);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    public int[] solution(){
        int[] nums1 = {1,2,1};
        int[] nums2 = {1,1};
        int len = Math.min(nums1.length,nums2.length);
        int[] tem = new int[len];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        int index = 0;
        while (i<nums1.length && j<nums2.length){
            if ( nums1[i] != nums2[j]){
                if (nums1[i] > nums2[j]) j++;
                else if (nums1[i] < nums2[j]) i++;
            }else {
                if (index == 0){
                    tem[index] = nums1[i];
                    i++;
                    j++;
                    index++;
//                }else if (nums1[i] == tem[index-1]){
//                    i++;
//                    j++;
                }else {
                    tem[index] = nums1[i];
                    index++;
                    i++;
                    j++;
                }
            }
        }
        return Arrays.copyOfRange(tem,0,index);
    }
    /**
     *      方法 2 ：
     *      借助 hashMap的计数进行操作
     * */


    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }
}
