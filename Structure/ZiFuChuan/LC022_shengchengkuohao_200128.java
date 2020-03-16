package LeetCode.Structure.ZiFuChuan;

import java.util.ArrayList;
import java.util.List;

public class LC022_shengchengkuohao_200128 {

    public static void main(String args []) {

        LC022_shengchengkuohao_200128 Solution = new LC022_shengchengkuohao_200128();
        List ret = Solution.solution();
        System.out.print(ret);
    }

    public List solution(){
        int num = 3;

        List ret = new ArrayList();
        int left = 0;
        int right = 0;
        String temp = "";
        builder(num,left,right,temp,ret);
        return ret;
    }
    public void builder(int num, int left, int right, String temp, List ret) {
        if (left == num && right == num) {
            ret.add(temp);
            return;
        }
        if (left == right && left<num){
            builder(num,left+1,right,temp+"(", ret);
        }
        if (left > right) {
            if (left < num){
                builder(num,left+1,right,temp+"(",ret);
            }
            builder(num,left,right+1,temp+")",ret);
        }
    }

}
