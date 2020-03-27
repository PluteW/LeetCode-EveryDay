package LeetCode.汇总;

public class LC409_zuichanghuiwenchuan_200319 {

    /**
     * @Description：    贪心算法
     *          奇数个数的字符，只能出现一种字符
     * @Params: String s 保存了所有字符的字符串
     * @return: int ans  能组成的最大回文子串的长度
     * @author: Mr.Wang
     * @create: 21:10
    */
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0)
                ans++;
        }
        return ans;
    }
}
