package LeetCode.Sort;

import java.util.Arrays;
import java.util.Comparator;

public class LC179_zuidashu_200220  {

    public static void main(String args[]) {
        LC179_zuidashu_200220 Solution = new LC179_zuidashu_200220();
        String ret = Solution.solution();
        System.out.println(ret);
    }

    private class comparor implements Comparator<String>{
//  两个参数a, b，若返回值是-1则a排前，即升序。若o2+o1小于o1+o2则返回-1，此时o1排前，符合o1+o2值更大时o1排在前的假设
        @Override
        public int compare(String a, String b) {
            String o1 = a+b;
            String o2 = b+a;
            int i = o2.compareTo(o1);
            return o2.compareTo(o1);
        }
    }

    public String solution() {
        int[] nums = {3,30,34,5,9};
        String[] strings = new String[nums.length];
        for (int i = 0;i<nums.length;i++){
            strings[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strings,new comparor());
        StringBuilder stringBuilder = new StringBuilder();
        if (strings[0].equals("0")){
            return "0";
        }
        for (String s : strings){
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }

}
