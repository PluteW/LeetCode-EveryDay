package LeetCode.汇总;

public class LC1071_zifuchuanzuidagongyinzi_200312 {

    public static void main(String[] args) {
        LC1071_zifuchuanzuidagongyinzi_200312 Solution = new LC1071_zifuchuanzuidagongyinzi_200312();
        String ret = Solution.solution();
        System.out.println(ret);
    }

    /**
     * @Description： 迭代，从长序列向短序列方向变化
     * @Params: String str1,str2  需要判断的俩子串
     * @return: String f  最长子串
     * @author: Mr.Wang
     * @create: 23:29
    */
    public String solution(){
        String str1 = "ABCABC";
        String str2 = "ABC";
        int len = Math.min(str1.length(),str2.length());
        for (int i = len;i>1;i--){
            if (str1.length()%i != str2.length()%i) continue;
            String f = str1.substring(0,i);
            if (check(str1,f) && check(str2,f))
                return f;
        }
        return "";
    }
    public boolean check(String s,String f){
        int sL = s.length();
        int fL = f.length();
        int n = sL/fL;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0;i<n;i++){
            stringBuilder.append(f);
        }
        if (stringBuilder.toString().equals(s))
            return true;
        return false;
    }

}
