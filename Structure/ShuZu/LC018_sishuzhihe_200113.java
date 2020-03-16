package LeetCode.Structure.ShuZu;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC018_sishuzhihe_200113 {

    public static void main(String atgs []) {
        List ret = solution();
        System.out.println(ret);
    }

    public static List solution() {

        int[] a = {-3,-2,-1,0,0,1,2,3};
        int target = 0;

        List ret = new ArrayList();

        Arrays.sort(a);
        for (int k = 0; k<a.length-3;k++) {

            /**
             *  存在跳出的极限，分以下两种情况：
             *      1、现在的 k 范围内的最小组合， 也就是 a[k] + a[k+1] + a[k+2] + a[k+3]
             *          如果这个数值都比最大值要大，那剩下的就可以直接舍弃（数组已经都排完序了）
             *      2、现在的 k 范围内的最大组合 ， 也就是 a[a.length-1] + a[a.length-2] +a[a.length-3] + a[a.length-4]
             *          如果这个数值都比最小值要小，那剩下的就可以直接舍弃
             * **/
            if ((a[k] + a[k+1] + a[k+2] + a[k+3]) > target ||
                    (a[a.length-1] + a[a.length-2] +a[a.length-3] + a[a.length-4]) <target)
                break;
            /**
             *  上述两个状况都没有出现时，说明存在符合题目的解答方案，下面进入三指针法
             *      第一个数字的位置从 k 之后开始选取
             * **/

            for (int i = k+1; i< a.length-2 ; i++ ) {
                int l = i + 1;
                int r = a.length-1;
                while (l<r) {
                    int sum = a[k] + a[i] + a[l] + a[r];
                    if ( sum == target) {
                        int[] tem = new int[]{ a[k], a[i], a[l], a[r] };
                        ret.add(tem);
                        r--;
                        while (r > i+1 && a[r] == a[r+1]) r--;
                        l++;
                        while (l < r-1 && a[l] == a[l-1]) l++;
                    }else if (sum < target) {
                        l++;
                    }else {
                        r--;
                    }
                }
                while (i<a.length-2&& a[i] == a[i+1]) i++;
            }
            while (k<a.length-3&&a[k] == a[k+1]) k++;
        }
        return  ret;
    }


}
