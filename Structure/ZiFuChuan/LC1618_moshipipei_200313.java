package LeetCode.Structure.ZiFuChuan;

import java.util.Arrays;

public class LC1618_moshipipei_200313 {

    public static void main(String[] args) {
        LC1618_moshipipei_200313 Solution = new LC1618_moshipipei_200313();
        boolean ret = Solution.patternMatching("abba","dogcatcatdog");
        System.out.println(ret);
    }

    public boolean patternMatching(String pattern, String value) {
        if(pattern.length() == 0) {
            if(value.length() == 0) return true;
            return false;
        }
        int count_a = 0;
        int count_b = 0;
        for(int i = 0; i < pattern.length(); i++) {         // 先对 a 和 b 出现的次数进行统计
            if(pattern.charAt(i) == 'a') count_a++;
            else count_b++;
        }
        if(value.length() == 0) {                           // 如果值串为空，则可以由模式串来进行直接判断
            if(count_a != 0 && count_b != 0) return false;
            return true;
        }
        if(count_a == 0 || count_b == 0) {          // 如果模式串中只有一个子集，则可以直接通过计数来拼凑，看结果是否相同
            String patternString = value.substring(0, (value.length() / (count_a + count_b)));
            if(patternString.length() * (count_a + count_b) != value.length()) return false;
            int patternStringLength = patternString.length();
            for(int i = 0; i < value.length(); i += patternStringLength)
                if(! value.substring(i, i + patternStringLength).equals(patternString)) return false;
            return true;
        }
        int pattern_pos = 0;
        int pattern_a_length = 0;
        int pattern_b_length = 0;
        String[] res = new String[2];
        int max_pattern_a = value.length() / count_a;
        for(; pattern_a_length <= max_pattern_a; pattern_a_length++) {
            Arrays.fill(res, "");
            pattern_b_length = (value.length() - count_a * pattern_a_length) / count_b;
            if(pattern_b_length * count_b + count_a * pattern_a_length != value.length()) continue;
            pattern_pos = 0;
            int i = 0;
            for(; i < pattern.length(); i++) {
                char ch = pattern.charAt(i);
                if(ch == 'a') {
                    if(pattern_a_length != 0 && res[0].equals("")) res[0] = value.substring(pattern_pos, pattern_pos + pattern_a_length);
                    else if(pattern_pos + pattern_a_length > value.length()
                            || ! value.substring(pattern_pos, pattern_pos + pattern_a_length).equals(res[0])) break;
                    pattern_pos += pattern_a_length;
                }
                else {
                    if(pattern_b_length != 0 && res[1].equals("")) res[1] = value.substring(pattern_pos, pattern_pos + pattern_b_length);
                    else if(pattern_pos + pattern_b_length > value.length()
                            || ! value.substring(pattern_pos, pattern_pos + pattern_b_length).equals(res[1])) break;
                    pattern_pos += pattern_b_length;
                }
                if(pattern_a_length != 0 && pattern_b_length != 0 && res[0].equals(res[1])) break;
            }
            if(i == pattern.length()) return true;
        }
        return false;
    }

}
