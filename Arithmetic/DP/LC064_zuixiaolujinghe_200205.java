package LeetCode.Arithmetic.DP;

public class LC064_zuixiaolujinghe_200205 {

    public static void main(String args[]) {
        LC064_zuixiaolujinghe_200205 Solution = new LC064_zuixiaolujinghe_200205();
        int ret = Solution.solution();
        System.out.println(ret);
    }

//    方法 1 ：使用二维数组来存储该点到终点的最短路径和
    public int solution() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};

        int row_length = grid.length;
        int line_length = grid[0].length;
        int[][] ret = new int[row_length][line_length];

        for (int i = row_length-1;i>-1;i--){
            for (int j = line_length-1;j>-1;j--){
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    ret[i][j] = grid[i][j] +  ret[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    ret[i][j] = grid[i][j] + ret[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    ret[i][j] = grid[i][j] + Math.min(ret[i + 1][j], ret[i][j + 1]);
                else
                    ret[i][j] = grid[i][j];
            }
        }
        return ret[0][0];
    }
//  方法 2： 使用一维数组来逐步更新最短路径和
    public int solution2() {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int[] ret = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    ret[j] = grid[i][j] +  ret[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    ret[j] = grid[i][j] + ret[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    ret[j] = grid[i][j] + Math.min(ret[j], ret[j + 1]);
                else
                    ret[j] = grid[i][j];
            }
        }
        return ret[0];
    }
//    方法 3： 不需要额外空间
    public int solution3(){
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    grid[i][j] = grid[i][j] +  grid[i][j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j],grid[i][j + 1]);
            }
        }
        return grid[0][0];
    }

}
