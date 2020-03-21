package LeetCode._test;

import java.util.Arrays;

public class Dijkstra_200321 {
    public static void main(String[] args) {
        Dijkstra_200321 Solution = new Dijkstra_200321();
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        final int INF = Integer.MAX_VALUE;
        int matrix[][] = {
                        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};
        matrixUDG mu = Solution.new matrixUDG(vexs, matrix);
        mu.start(3);
    }

    class matrixUDG {
        final int INF = Integer.MAX_VALUE;
        int numNodes;
        int[][] matrix;
        int[] prev;
        int[] dist;
        char[] vexs;

        //初始化图参数
        public matrixUDG(char[] vexs, int[][] matrix) {
            this.vexs = vexs;
            this.matrix = matrix;
            numNodes = vexs.length;
            prev = new int[numNodes];
            dist = new int[numNodes];
        }
        public void start(int vx){
            for (int i = 0;i<dist.length;i++){
                dist[i] = matrix[vx][i];
            }
            boolean[] visited = new boolean[dist.length];
            Arrays.fill(visited,false);
            visited[vx] = true;
            for (int i = 0;i<dist.length;i++){
                int max = INF;
                int k = 0;
                for (int j = 0;j<dist.length;j++){
                    if (visited[j] == false && dist[j]<max){
                        max = dist[j];
                        k = j;
                    }
                }
                visited[k] = true;
                for (int p = 0;p<dist.length;p++){
                    if (visited[p] == false && matrix[k][p] != INF && matrix[k][p]+dist[k] < dist[p]){
                        dist[p] = dist[k] + matrix[k][p];
                        prev[p] = k;
                    }
                }
            }
        }
    }
}
