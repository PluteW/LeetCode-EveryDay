package LeetCode.汇总;

import java.util.ArrayList;
import java.util.List;

public class LC043_zifuchuanxiancheng_200130 {

    public static void main(String args[]) {

        LC043_zifuchuanxiancheng_200130 Solution = new LC043_zifuchuanxiancheng_200130();
        String ret = Solution.solution();
        System.out.print(ret);

    }

    public String solution(){

        String str1 = "123";
        String str2 = "12345";
        List nums = new ArrayList();
        if (str1.length()>str2.length()){
            multiplication(str1,str2,nums);
            System.out.print(nums);
        }else {
            multiplication(str2,str1,nums);
            System.out.print(nums);
        }

        int[] temp = new int[str1.length()+str2.length()];
        int carry = 0;
        for (int i = temp.length-1;i>-1;i--) {

            for (int j = 0;j<nums.size();j++){
                int[] t = (int[]) nums.get(j);
                temp[i] += t[i];
            }
            temp[i] += carry;
            carry = temp[i]/10;
            temp[i] = temp[i]%10;
        }
        String ret = "";
        for (int i = 0;i <temp.length;i++){
            if (temp[i] != 0){
                while (i<temp.length){
                    ret = ret+String.valueOf(temp[i]);
                    i++;}
                break;
            }
        }
        return ret;
    }

    public void multiplication(String str_Long, String str_Short,List nums){
        int len_Long = str_Long.length();
        int len_Short = str_Short.length();
        int len_Total = len_Long+len_Short;
        for (int i = len_Short-1;i>-1;i--) {
            int carry = 0;
            int[] temp = new int[len_Total];
            int num_short = str_Short.charAt(i)-'0';
            for (int j = len_Long-1; j>-1;j--) {
                int num_long = str_Long.charAt(j)-'0';
                int count = len_Long-1 - ( len_Short -1- i) - j;
                temp[count] = (num_long*num_short+carry)%10;
                carry = (num_long*num_short+carry)/10;
                if (j == 0 && carry !=0)
                    temp[count-1] = carry;
            }
            nums.add(temp);
        }
    }

}
