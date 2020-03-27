package LeetCode.汇总;

import java.util.Arrays;

public class LC1001_hebingpaixushuzu_200303 {
    public static void main(String[] args) {
        LC1001_hebingpaixushuzu_200303 Solution = new LC1001_hebingpaixushuzu_200303();
        Solution.solution2();
    }
/**
 * @Description： 借助java原生的sort函数进行排序
 * @Params:
 * @return:
 * @author: Mr.Wang
 * @create: 22:15
*/
    public void solution(){
        int[] A = {1,2,3,0,0,0};
        int m = 3;
        int[] B = {2,5,6};
        int n = 3;
        for (int i = m,j = 0;i<A.length;i++,j++){
            A[i] = B[j];
        }
        Arrays.sort(A);
    }

    /**
     * @Description： 反向双指针方法
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 22:36
    */
    public void solution2(){
        int[] A = {0};
        int m = 0;
        int[] B = {1};
        int n = 1;
        int i = m+n-1;
        int j = n-1;
        int k = m-1;
        while (j>-1 || k>-1){
            if (j == -1){
                A[i] = A[k];
                k--;
            } else if(k == -1){
                A[i] =B[j];
                j--;
            }else if (A[k]>B[j]){
                A[i] = A[k];
                k--;
            }else {
                A[i] = B[j];
                j--;
            }
            i--;
        }
    }

}
