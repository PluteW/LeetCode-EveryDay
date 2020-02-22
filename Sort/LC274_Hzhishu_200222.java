package LeetCode.Sort;

import java.util.Arrays;

public class LC274_Hzhishu_200222 {

    public static void main(String[] args) {
        LC274_Hzhishu_200222 Solution = new LC274_Hzhishu_200222();
        int ret = Solution.solution();
        System.out.println(ret);
    }

    public int solution() {
        int[] citations = {3,0,6,1,5};
        Arrays.sort(citations);
        int i = 0;
        while (i < citations.length && citations[citations.length - 1 - i] > i ){
            i++;
        }
        return i;
    }
}
