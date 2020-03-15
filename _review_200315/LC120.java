package LeetCode._review_200315;

import java.util.List;

public class LC120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
//       临时数组多加一位，相当于是标兵
        int[] temp = new int[row+1];
//        外层循环从下往上进行遍历
        for (int i = row-1;i>-1;i--){
//            内层循环从左往右进行遍历，更新当前位置的最小和
//            这一行的元素数与行号相同
            for (int j = 0;j<=i;j++){       // 使用列来限制内存循环
                temp[j] = Math.min(temp[j],temp[j+1]) + triangle.get(i).get(j);
            }
        }
        return temp[0];
    }
}
