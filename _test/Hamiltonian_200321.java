package LeetCode._test;

public class Hamiltonian_200321 {
    public static void main(String[] args) {
        Hamiltonian_200321 test = new Hamiltonian_200321();
        int[][] adjMatrix = {{-1,1,1,1,-1,-1},
                {1,-1,1,-1,-1,1},
                {1,1,-1,1,1,-1},
                {1,-1,1,-1,1,-1},
                {-1,-1,1,1,-1,1},
                {-1,1,-1,-1,1,-1}};
        test.getHamiltonCircuit(adjMatrix);
    }
    public void getHamiltonCircuit(int[][] adjMatrix){
        boolean[] used = new boolean[adjMatrix.length];
        int[] path = new int[adjMatrix.length];
        for (int i = 0;i<adjMatrix.length;i++){
            used[i] = false;
            path[i] = -1;
        }
        used[0] = true;
        path[0] = 0;
        dfs(adjMatrix,used,path,1);
    }
    public boolean dfs(int[][] adjMatrix,boolean[] used,int[] path,int step){
        if (step == adjMatrix.length){
            if (adjMatrix[path[step-1]][0] == 1){
                for (int i = 0;i<path.length;i++){
                    System.out.print((char)(path[i]+'a')+"->");
                }
                System.out.println((char)(path[0]+'a'));
//                return true;          // 这里如果直接返回，则只会生成一条路径，如果不返回，则可以生成所有的哈密顿路径
            }
            return false;
        }else {
            for (int i = 0;i<adjMatrix.length;i++){
                if (!used[i] && adjMatrix[path[step-1]][i] == 1){
                    used[i] = true;
                    path[step] = i;
                    if (dfs(adjMatrix,used,path,step+1)){
                        return true;
                    }else {
                        path[step] = -1;
                        used[i] = false;
                    }
                }
            }
        }
        return false;
    }
}
