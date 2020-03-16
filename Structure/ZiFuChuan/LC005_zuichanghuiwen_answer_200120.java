package LeetCode.Structure.ZiFuChuan;

public class LC005_zuichanghuiwen_answer_200120 {

    public static void main(String args[]){
        String s = "babad";
        LC005_zuichanghuiwen_answer_200120 Solution = new LC005_zuichanghuiwen_answer_200120();
        String ret = Solution.longestPalindrome(s);
        System.out.println(ret);
    }

//    方法1：中心扩展算法
//    时间复杂度：O(n^2)由于围绕中心来扩展回文会耗去 O(n)O(n) 的时间，所以总的复杂度为 O(n^2)
//    空间复杂度：O(1)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

//    方法2：动态规划法
//    方法3：Manacher 难度超纲，暂不讨论
}
