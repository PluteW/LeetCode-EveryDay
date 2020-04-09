package LeetCode.汇总;

import java.util.LinkedList;
import java.util.List;

public class LC060_diKgepailie_200409 {


    public static void main(String[] args) {
        LC060_diKgepailie_200409 Solutin = new LC060_diKgepailie_200409();
        String ret = Solutin.getPermutation(5,40);

    }

    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        //每个阶层的值
        int factor[]={1,1,2,6,24,120,720,5040,40320};
        List<Integer> list = new LinkedList<>();
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);list.add(6);list.add(7);list.add(8);list.add(9);
        //从第一位开始算每一位的值
        for(int i = n; i > 0; i--) {
            //这是每一位的值所在的具体位置
            int sv = k / factor[i - 1];
            k = k % factor[i - 1];
            sv = k > 0 ? sv + 1 : sv;
            if (k == 0) k = factor[i - 1];
            sb.append(list.remove(sv - 1));
        }
        return sb.toString();
    }
}
