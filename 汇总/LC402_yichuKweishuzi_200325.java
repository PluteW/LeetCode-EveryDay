package LeetCode.汇总;

import java.util.Deque;
import java.util.LinkedList;

public class LC402_yichuKweishuzi_200325 {
    /**
     * @Description：  使用栈的思想
     *              先弹出后者大于前者的情况
     *              对于数目不够的部分，就从后面开始弹出
     * @Params：    String num 保存着数字的字符串  int k 需要弹出K位数字
     * @return:     String  ret 保存着删除完K位数字的结果的字符串
     * @author:     Mr.Wang
     * @create:     22:20
    */
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<Character>();
        for(char digit : num.toCharArray()) {
            while(stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }
            stack.addLast(digit);
        }
        /* remove the remaining digits from the tail. */
        for(int i=0; i<k; ++i) {
            stack.removeLast();
        }
        // build the final string, while removing the leading zeros.
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for(char digit: stack) {
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }
        /* return the final string  */
        if (ret.length() == 0) return "0";
        return ret.toString();
    }

    /**
     * @Description：    不适用特别的数据结构，更好理解
     * @Params：    String num 保存着数字的字符串  int k 需要弹出K位数字
     * @return:     String  ret 保存着删除完K位数字的结果的字符串
     * @author:     Mr.Wang
     * @create:     22:23
    */
    public String removeKdigits2(String num, int k){
        char[] str = num.toCharArray();//首先，我们将num转化成字符数组
        int length = num.length();	//用length去记录移除k个数后返回字符串的长度。
        //也许你会有疑问“返回的字符串长度不就是 num.length - k 吗？”
        if(k==0)
            return num;
        if(k==num.length())
            return "0";
        while(k!=0){
            int i;
            int flag = 1;
            for(i = 0; i < str.length - 1; i++){
                if((int)str[i]>(int)str[i+1]){
                    for(int t = i; t < str.length - 1; t++)
                        str[t] = str[t+1];
                    flag = 0;
                    length--;//删除之后，返回的长度-1，k-1，跳出for循环
                    k--;
                    break;
                }
            }
            if(flag == 1 && k!=0){
                length--;	//那说明最后一个>=倒数第二个
                k--;	//所以length--，k--.（length--相当于删除了。。。往下看）
            }
        }
        boolean cut = true;
        while(cut){
            cut = false;
            if(str[0]=='0'&&length!=1){
                cut = true;
                for(int t = 0; t < str.length - 1 ; t++){
                    str[t] = str[t+1];
                }
                length--;
            }
        }
        char[] pre = new char[length];//建立一个新数组,去记录0到length-1
        for(int i = 0; i < length; i++){
            pre[i] = str[i];
        }
        return String.valueOf(pre);//返回这个新的数组
    }
}
