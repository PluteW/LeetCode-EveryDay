package LeetCode.Arithmetic.Greed;

import java.util.ArrayList;
import java.util.List;

public class LC131_fengehuiwenzifuchuan_200430 {

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        if ( s == null || s.length() == 0) {
            return ans;
        }
        // 回溯
        helper(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    // 创建回溯方法体，中间两参数分别代表当前位置和存放符合要求的分割数组
    private void helper(String s, int pos, List<String> cur, List<List<String>> ans) {
        int len = s.length();
        if (pos == len) {
            // 这里要传入初始化的 cur，以免因 cur 发生改变而影响结果
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = pos; i < len; i++) {
            if (pos == len) {
                break;
            }
            // 如果当前遍历到的子串是回文串
            if (isPalindrome(s.substring(pos, i + 1))) {
                // 就将其加入到 cur 中
                cur.add(s.substring(pos, i + 1));
                // 递归遍历下一个
                helper(s, i + 1, cur, ans);
                // 回退到上一个元素继续（回溯）
                cur.remove(cur.size() - 1);
            }
        }
    }

    // 判断是否是回文
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
