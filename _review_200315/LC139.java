package LeetCode._review_200315;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for (String str : wordDict){
            set.add(str);
        }
        boolean[] ret = new boolean[s.length()+1];
        ret[0] = true;
        for (int i = 1;i<ret.length;i++){
            for (int j = 0; j <i;j++){
                if (ret[j] && set.contains(s.substring(j,i))){
                    ret[i] = true;
                    break;
                }
            }
        }
        return ret[s.length()];
    }

    /**
     * @Description：   方法 2 ： 暴力回溯
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 15:51
    */
    public boolean wordBreak2(String s, List<String> wordDict) {
        return word_Break(s, new HashSet(wordDict), 0);
    }
    public boolean word_Break(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && word_Break(s, wordDict, end)) {
                return true;
            }
        }
        return false;
    }

}
