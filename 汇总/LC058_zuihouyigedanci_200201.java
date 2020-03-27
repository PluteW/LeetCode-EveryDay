package LeetCode.汇总;

public class LC058_zuihouyigedanci_200201 {

    public static void main(String args[]) {
        LC058_zuihouyigedanci_200201 Solution = new LC058_zuihouyigedanci_200201();
        int ret = Solution.solution2();
        System.out.print(ret);
    }

//    自己的尝试，对于Hello world有效，但不能通过提交
//    对于全是空格的字符串无效
//    更改后，提交成功
    public int solution(){
        String s = " ";
        String[] strings = s.split(" ");
        if (s.length() == 0  || strings.length == 0){
            return 0;
        }
        String ret = strings[strings.length-1];
        return ret.length();
    }

    public int solution2(){
        String s = "Hello world";
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
}
