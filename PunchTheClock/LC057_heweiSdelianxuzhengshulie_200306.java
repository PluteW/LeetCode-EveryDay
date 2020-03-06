package LeetCode.PunchTheClock;

import java.util.ArrayList;
import java.util.List;

public class LC057_heweiSdelianxuzhengshulie_200306 {

    public static void main(String[] args) {

    }

    /**
     * @Description：  使用滑动窗口法（ 使用的是左闭右开窗 ）
     * @Params: target 目标值
     * @return: int[][] 保存有结果的二维数组
     * @author: Mr.Wang
     * @create: 23:09
    */
    public int[][] solution(){
        int target = 15;
        int l = 1;
        int r = 1;
        int sum = 0;
        List<int[]> ret = new ArrayList<int[]>();
        while (l <= target /2){
            if (sum>target){
                sum -= l;
                l++;
            }else if (sum<target){
                sum += r;
                r++;
            }else {
                int[] temp = new int[r-l];
                for (int i = l,j=0;i<r;i++,j++){
                    temp[j] = i;
                }
                ret.add(temp);
                sum -= l;
                l++;
            }
        }
        return ret.toArray(new int[ret.size()][]);
    }

}
