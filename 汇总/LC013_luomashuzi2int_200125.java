package LeetCode.汇总;

public class LC013_luomashuzi2int_200125 {

    public static void main(String args[]) {
        LC013_luomashuzi2int_200125 Solution = new LC013_luomashuzi2int_200125();
        int ret = Solution.solution();
        System.out.print(ret);
    }

    public int solution() {
        int ret = 0;

        String s = "CDIVIII";

        if (s.length() == 0)
            return 0;
        int current = 0;
        int last = 0;
        for (int  i = s.length()-1; i>-1;i--){
            current = switcher(s.charAt(i));
            if (current < last){
                ret -= current;
            }else {
                ret += current;
            }
            last = current;
        }
        return ret;
    }
    public int switcher(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
                default:
                    return 0;
        }
    }

}
