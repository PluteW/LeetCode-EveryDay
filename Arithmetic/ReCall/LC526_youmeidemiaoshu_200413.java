package LeetCode.Arithmetic.ReCall;

public class LC526_youmeidemiaoshu_200413 {
    
    /**
     * @Description：  获得优美的排列的数目
     * @Params:  int N      参与排列的数字
     * @return:  int count  优美排列的数目
     * @author: Mr.Wang
     * @create: 23:47
    */
    int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N + 1];
        calculate(N, 1, visited);
        return count;
    }
    public void calculate(int N, int pos, boolean[] visited) {
        if (pos > N)
            count++;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
                visited[i] = true;
                calculate(N, pos + 1, visited);
                visited[i] = false;
            }
        }
    }
}
