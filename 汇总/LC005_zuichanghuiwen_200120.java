package LeetCode.汇总;

public class LC005_zuichanghuiwen_200120 {

    public static void main(String args[]) {
        LC005_zuichanghuiwen_200120 Soluton = new LC005_zuichanghuiwen_200120();
        String ret = Soluton.solution();
        System.out.println(ret);
    }

    public String solution(){
        String string = "babad";
        String ret = "";

        int begin = 0;
        int end = string.length()-1;
        int length = end-begin+1;
        while (begin<=end){
            length = end-begin+1;
            if (string.charAt(begin) == string.charAt(end)) {
                for (int i = begin,j = end;i<=j;i++,j--){
                    if (string.charAt(i) != string.charAt(j)){
                        break;
                    }
                }
            }
            begin++;
            end = string.length()-1;
        }
        System.out.println(length);
        return ret;
    }
}
