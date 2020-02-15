package LeetCode.ZiFuChuan;

public class LC008_huoquzhengshu_200122 {

    public static void main(String args[]) {

        LC008_huoquzhengshu_200122 Solution = new LC008_huoquzhengshu_200122();
        int ret = Solution.solution();
        System.out.print(ret);
    }
//  第一版：获得了所有的数字    wrong
    public int solution() {
        String str = "-4193 with words";

        int ret = 0;
        char[] chars = str.toCharArray();
        char c;
        int begin = -1;
        boolean negtive = false;
        for (int i = 0;i<chars.length;i++){
            c = chars[i];
            if ((byte)c >=48 && (byte)c <=57 ){
                if (ret == 0){
                    if (i>0&&(byte)(chars[i-1])==45){
                        begin = i;
                        negtive = true;
                    }
                }
                ret = ret*10+Character.getNumericValue(c);
            }
            if (ret != 0 && !((byte)c >=48 && (byte)c <=57))
                break;
        }
        if (begin > -1)
            ret = ret*(negtive?(-1):1);

        return ret;
    }
//    网上方法
    public int solution2(){
        String str = "-4193 with words";
        if(str==null || str.length()==0)
            return 0;
        //1.跳过空字符; 这里使用str.trim()也可以去掉字符串两端的空字符, 但是不能击败99.96%了...
        int i =0;
        while(i<str.length() && str.charAt(i)==' '){
            i++;
        }
        //此时,i指向第一个不为空的字符 或者 i越界
        if(i==str.length())
            return 0;
        //2.判断数字的符号
        int flag=1;
        char ch = str.charAt(i);
        if(ch=='+'){
            flag = 1;
            i++;
        }
        if(ch>='0' && ch<='9')
            flag = 1;
        if(ch=='-'){
            flag = -1;
            i++;
        }
        //3.找出数字部分
        int res = 0;
        for(; i<str.length(); i++){
            ch = str.charAt(i);
            if(ch<'0' || ch>'9')
                break;
            res = res*10 + ch-'0';
            //溢出判断
            if(flag>0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && res > Integer.MAX_VALUE/10)
                return Integer.MAX_VALUE;
            if(flag>0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && res == Integer.MAX_VALUE/10 && str.charAt(i+1)-'0' > Integer.MAX_VALUE%10)
                return Integer.MAX_VALUE;
            if(flag<0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && -res < Integer.MIN_VALUE/10)
                return Integer.MIN_VALUE;
            if(flag<0 && i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9' && -res == Integer.MIN_VALUE/10 && -(str.charAt(i+1)-'0') < Integer.MIN_VALUE%10)
                return Integer.MIN_VALUE;
        }
        return res * flag;
    }
}
