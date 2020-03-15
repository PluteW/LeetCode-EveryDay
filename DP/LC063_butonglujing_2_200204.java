package LeetCode.DP;

public class LC063_butonglujing_2_200204 {

    public static void main(String args[]) {

        LC063_butonglujing_2_200204 Solution = new LC063_butonglujing_2_200204();
        int ret = Solution.solution();
        System.out.println(ret);
    }

    public int solution() {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

        int row_length = obstacleGrid.length;
        int line_length = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1;i<row_length;i++)
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 0 && obstacleGrid[i-1][0] == 1) ? 1 : 0;
        for (int i = 1;i<line_length;i++)
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 0 && obstacleGrid[0][i-1] == 1) ? 1 : 0;
        for (int i = 1;i<row_length;i++){
            for (int j = 1; j<line_length;j++){
                if (obstacleGrid[i][j] == 0){
                    obstacleGrid[i][j] = obstacleGrid[i][j-1] + obstacleGrid[i-1][j];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[row_length-1][line_length-1];
    }

}
