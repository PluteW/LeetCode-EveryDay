package LeetCode.Structure.ZiFuChuan;

public class LC012_int2luomashuzi_200123 {

    public static void main(String args[]) {
        LC012_int2luomashuzi_200123 Solution = new LC012_int2luomashuzi_200123();
        String ret = Solution.solution();
        System.out.print(ret);
    }

    public String solution(){
        int num = 586;
        StringBuilder ret = new StringBuilder();

        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] range = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int i = 0;
        while (num>0){
            int count = num/range[i];
            while (count-->0)
                ret.append(roman[i]);
            num = num%range[i];
            i++;
        }

        return ret.toString();
    }
}
