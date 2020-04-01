package LeetCode.汇总;

public class LC1111_youxiaokuohaodeqinantaoshendu_200401 {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int deepth = 0;
        int i = -1;
        for( char c : seq.toCharArray()){
            i++;
            if (c == '(') {
                deepth++;
                ans[i] = deepth % 2;
            }
            if (c == ')'){
                ans[i] = deepth% 2;
                deepth--;
            }
        }
        return ans;
    }
}
