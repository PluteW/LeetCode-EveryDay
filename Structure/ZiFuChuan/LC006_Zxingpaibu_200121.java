package LeetCode.Structure.ZiFuChuan;

import java.util.ArrayList;
import java.util.List;

public class LC006_Zxingpaibu_200121 {

    public static void main(String args[]) {
        LC006_Zxingpaibu_200121 Solution = new LC006_Zxingpaibu_200121();
        String ret = Solution.solution();
        System.out.print(ret);
    }

//    借助StringBuilder，来逐个取出和排列
    public String solution(){

        String s = "LEETCODEISHIRING";
        int rows_count = 3;

        if (s.length() == 0 || rows_count == 1){
            return s;
        }

        List<StringBuilder> rows = new ArrayList();
        int row_num = Math.min(s.length(),rows_count);
        for (int i=0;i<row_num;i++){
            rows.add(new StringBuilder());
        }

        boolean down = false;
        int current_row = 0;
        for (char c:s.toCharArray()){
            rows.get(current_row).append(c);
            if (current_row == 0 || current_row == rows_count-1) down = !down;
            current_row += down?1:-1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder stringBuilder : rows){
            ret.append(stringBuilder);
        }


        return ret.toString();
    }
//    使用数学计算获得各个点的位置
    public String solution2() {

        String s = "LEETCODEISHIRING";
        int rows_count = 3;

        if (s.length() == 0 || rows_count == 1){
            return s;
        }

        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * rows_count - 2;

        for (int i = 0; i < rows_count; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != rows_count - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
}
