package LeetCode.DP;

import java.util.Arrays;

public class LC062_butonglujing_200203 {
    public static void main(String args[]) {
        LC062_butonglujing_200203 Solution = new LC062_butonglujing_200203();
        int ret = Solution.solution2();
        System.out.println(ret);
    }

    public int solution(){
        int m = 2;
        int n = 3;

        int[][] array = new int[m][n];
        for (int i = 0; i < n; i++) array[0][i] = 1;
        for (int i = 0; i < m; i++) array[i][0] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }
        return array[m - 1][n - 1];
    }
    public int solution2(){
        int m = 3;
        int n = 2;

        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] = cur[j-1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n-1];
    }

    public int solution3(){
        int m = 2;
        int n = 3;
        int[] cur = new int[n];
        Arrays.fill(cur,1);
        for (int i = 1; i < m;i++){
            for (int j = 1; j < n; j++){
                cur[j] += cur[j-1] ;
            }
        }
        return cur[n-1];
    }

}
