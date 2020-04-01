package LeetCode._PunchTheClock;

public class LC1111_youxiaokuohaodeqinantaoshendu_200401 {
    /**
     * @Description：  分奇偶压栈
     * @Params:     String seq  待处理的字符串
     * @return:     int[] ret   保存结果的数组
     * @author: Mr.Wang
     * @create: 22:16
    */
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
