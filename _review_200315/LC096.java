package LeetCode._review_200315;

public class LC096 {
    public int numTrees(int n) {
        int[] ret = new int[n+1];
        ret[0] = 1;
        ret[1] = 1;
        for (int i = 2;i<=n;i++){
            for (int t = 0;t<i;t++){
                ret[i] += ret[t]*ret[i-1-t];
            }
        }
        return ret[n];
    }
}
