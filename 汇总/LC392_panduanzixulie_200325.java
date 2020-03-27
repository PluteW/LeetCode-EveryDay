package LeetCode.汇总;

public class LC392_panduanzixulie_200325 {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        int m = s.length(), n = t.length();
        while(i < m && j < n){
            if(s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }
            else j++;
        }
        return i == m;
    }
}
