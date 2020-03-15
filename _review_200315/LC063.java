package LeetCode._review_200315;

public class LC063 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int cow = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1;i<row;i++){
            obstacleGrid[i][0] = (obstacleGrid[i-1][0] == 1 && obstacleGrid[i][0] == 0) ? 1: 0;     // 当前位置必须可达
        }
        for (int i = 1;i<cow;i++){
            obstacleGrid[0][i] = (obstacleGrid[0][i-1] == 1 && obstacleGrid[0][i] == 0) ? 1 : 0;    // 当前位置必须可达
        }
        for (int i = 1;i<row;i++){
            for (int j = 1;j<cow;j++){
                if (obstacleGrid[i][j] == 1){                               // 如果当前位置就不可达，那就赋值为 0
                    obstacleGrid[i][j] = 0;
                }else {
                    obstacleGrid[i][j] = obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[row-1][cow-1];
    }
}
