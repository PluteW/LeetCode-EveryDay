package LeetCode._test;

public class Hamiltonian {
    public static void main(String[] args) {
        Hamiltonian test = new Hamiltonian();
        int[][] adjMatrix = {{-1,1,1,1,-1,-1},
                {1,-1,1,-1,-1,1},
                {1,1,-1,1,1,-1},
                {1,-1,1,-1,1,-1},
                {-1,-1,1,1,-1,1},
                {-1,1,-1,-1,1,-1}};
        test.getHamiltonCircuit(adjMatrix);
    }
    public void getHamiltonCircuit(int[][] adjMatrix) {
        boolean[] used = new boolean[adjMatrix.length];       //用于标记图中顶点是否被访问
        int[] path = new int[adjMatrix.length];       //记录哈密顿回路路径
        for(int i = 0;i < adjMatrix.length;i++) {
            used[i] = false;     //初始化，所有顶点均未被遍历
            path[i] = -1;        //初始化，未选中起点及到达任何顶点
        }
        used[0] = true;          //表示从第1个顶点开始遍历
        path[0] = 0;             //表示哈密顿回路起点为第0个顶点
        dfs(adjMatrix, path, used, 1);     //从第0个顶点开始进行深度优先遍历,如果存在哈密顿回路，输出一条回路，否则无输出
    }
    /*
     * 参数step:当前行走的步数，即已经遍历顶点的个数
     */
    public boolean dfs(int[][] adjMatrix, int[] path, boolean[] used, int step) {
        if(step == adjMatrix.length) {     //当已经遍历完图中所有顶点
            if(adjMatrix[path[step - 1]][0] == 1) { //最后一步到达的顶点能够回到起点
                for(int i = 0;i < path.length;i++)
                    System.out.print(((char)(path[i] + 'a'))+"——>");
                System.out.print(((char)(path[0] + 'a')));
                System.out.println();
                return true;
            }
            return false;
        } else {
            for(int i = 0;i < adjMatrix.length;i++) {
                if(!used[i] && adjMatrix[path[step - 1]][i] == 1) {
                    used[i] = true;
                    path[step] = i;
                    if(dfs(adjMatrix, path, used, step + 1))
                        return true;
                    else {
                        used[i] = false;    //进行回溯处理
                        path[step] = -1;
                    }
                }
            }
        }
        return false;
    }
}
