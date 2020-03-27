package LeetCode.汇总;

import java.util.ArrayList;
import java.util.List;

public class LC120_sanjiaoxingzuixiaolujing_200208 {

    public static void main(String args[]) {
        LC120_sanjiaoxingzuixiaolujing_200208 Solution = new LC120_sanjiaoxingzuixiaolujing_200208();
        int ret = Solution.solution();
        System.out.println(ret);
    }

//    从上到下，使用数组来存储结果

    public int solution() {
        int[][] t = {{2},{3,4},{6,5,7},{4,1,8,3}};

        int height = t.length;
        for (int i = 1; i < height; i++){
            t[i][0] += t[i-1][0];
            t[i][i] += t[i-1][i-1];
        }
        for (int i = 2;i <height;i++) {
            for (int j = 1;j<i;j++){
                t[i][j] += Math.min(t[i-1][j], t[i-1][j-1]);
            }
        }
        int ret = t[height-1][0];
        for (int i = 1;i<height;i++) {
            ret = Math.min(ret,t[height-1][i]);
        }
        return ret;
    }

//    方法 2： 从下到上，使用一维数组，扩展空间一定
    public int solution2(){
        List<List> triangle = new ArrayList<>();

        int row = triangle.size();
        int ret[] = new int[row+1];
        for (int i = row-1;i>-1;i--){
            for (int j = 0;j<=i;j++) {
                ret[j] = Math.min(ret[j], ret[j + 1]) + (int)triangle.get(i).get(j);
            }
        }
        return ret[0];
    }

}
