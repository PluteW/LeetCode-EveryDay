package LeetCode.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class LC349_shuzujiaoji_200225 {

    public static void main(String args[]) {

        LC349_shuzujiaoji_200225 Solution = new LC349_shuzujiaoji_200225();
        int[] ret = Solution.solution();
        for (int i =0;i<ret.length;i++){
            System.out.print(ret[i]);
        }
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
                }else if (nums1[i] == tem[index-1]){
                    i++;
                    j++;
                }else {
                    tem[index] = nums1[i];
                    index++;
//                    i++;
//                    j++;
                }
            }
        }
        return Arrays.copyOfRange(tem,0,index);
    }

    public int[] solution2(){
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (Integer n : nums1) set1.add(n);
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (Integer n : nums2) set2.add(n);

        set1.retainAll(set2);

        int [] output = new int[set1.size()];
        int idx = 0;
        for (int s : set1) output[idx++] = s;
        return output;
    }
}
