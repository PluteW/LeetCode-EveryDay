package LeetCode.ShuZu;

import java.util.*;

public class LC015_sanshuhe_200111 {


    public static void main (String [] args ){

        solution();
    }
/**
 *
 * 不能成功运行！
 * **/
    public static List solution(){

        int[] a = {0,0,0,0};
        List res = new ArrayList();        //初始化储存结果的数组
        Arrays.sort(a);         //将原数据数组进行排序
        int[] tem = {};
        HashSet hash= new HashSet<>();

        int l = 0;
        int r = a.length-1;
        int i = 0;
        int sum;

        while (i < a.length) {
            while ( l < i && i < r) {
                sum = a[l] + a[i] + a[r];
                if ( sum == 0){
                    if ( hash.contains(a[i])){
                        break;
                    }else {
                        hash.add(a[i]);
                        tem = new int[]{a[l], a[i], a[r]};
                        res.add(tem);
                        l++;
                        r = a.length-1;
                    }
                }else if ( sum > 0){
                    r--;
                }else if ( sum < 0){
                    l++;
                }
            }
            i++;
            l = 0;
            r = a.length-1;

        }
        return res;
    }


}
