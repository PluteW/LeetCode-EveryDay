package LeetCode._PunchTheClock;

public class LC999judekeyongbuhuoliang_200326 {
    /**
     * @Description：   暴力法
     *          先找到我们的 車 的位置，然后向四个方向进行期限搜索
     * @Params:     char[][ board  棋盘的布局情况
     * @return:     int cnt  能够捕获到的最大卒的数目
     * @author: Mr.Wang
     * @create: 23:14
    */
    public int numRookCaptures(char[][] board) {
        int cnt = 0, st = 0, ed = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if (board[i][j] == 'R') {
                    st = i;
                    ed = j;
                    break;
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            for (int step = 0;; ++step) {
                int tx = st + step * dx[i];
                int ty = ed + step * dy[i];
                if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') break;
                if (board[tx][ty] == 'p') {
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }
}
