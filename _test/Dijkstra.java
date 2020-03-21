package LeetCode._test;

public class Dijkstra {
    public static void main(String[] args) {
        Dijkstra Solution = new Dijkstra();
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
        public void start(int vs) {
            //初始化类参数
            boolean[] isVisited = new boolean[numNodes];
            for (int i = 0; i < isVisited.length; i++) {
                dist[i] = matrix[vs][i];
                prev[i] = -1;
                if (dist[i] != INF) {
                    prev[i] = vs;
                }
            }
            isVisited[vs] = true;
            //两次循环
            for (int i = 0; i < isVisited.length; i++) {
                int min = INF;
                int k = 0;
                //找到最近的节点
                for (int j = 0; j < isVisited.length; j++) {
                    if (!isVisited[j] && dist[j] < min) {
                        min = dist[j];
                        k = j;
                    }
                }

                isVisited[k] = true;
                //更新最近路径和父节点
                for (int j = 0; j < isVisited.length; j++) {
                    if (!isVisited[j] && matrix[k][j] != INF) {
                        if (dist[j] > matrix[k][j] + dist[k]) {
                            dist[j] = matrix[k][j] + dist[k];
                            prev[j] = k;
                        }
                    }
                }
            }
            System.out.println("===========");
        }

    }
}
