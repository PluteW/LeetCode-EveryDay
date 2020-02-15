package LeetCode.ShuZu;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC015_sanshuhe_answer_200111 {

    public static void main(String args[]){
        solutoion();
    }
    public static List solutoion(){

        int[] a = {-1,0,1,2,-1,-4};

        List res = new ArrayList();
        Arrays.sort(a);

        int sum;
        for (int i = 0; i<a.length; i++){

            if (a[i] > 0) break;            // ①
            if (a[i] == a[i-1]) continue;   // ②
            int l = i+1;                    // ③
            int r = a.length-1;
            while(l<r){
                sum = a[i] + a[l] + a[r];
                if (sum == 0){
                    int[] tem = new int[]{a[i],a[l],a[r]};
                    res.add(tem);
                    while (a[l] == a[l+1]) l++;     // ④
                    while (a[r] == a[r-1]) r--;
                    l++;
                    r--;
                }else if (sum > 0) {        // ⑤
                    r--;
                }else if ( sum < 0) {
                    l++;
                }
            }
        }
        return res;
    }

}
