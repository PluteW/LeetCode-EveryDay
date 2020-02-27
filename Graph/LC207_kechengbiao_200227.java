package LeetCode.Graph;

import java.util.LinkedList;

public class LC207_kechengbiao_200227 {
    public static void main(String[] args) {
        LC207_kechengbiao_200227 Solution = new LC207_kechengbiao_200227();
    }
    /**
     * @Description：    广度优先算法      拓扑排序
     * @Params:         课程数目 numCourses     依附关系    prerequisites
     * @return:         是否可以实现
     * @author: Mr.Wang
     * @create: 0:28
    */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];          // 入度表
        for(int[] cp : prerequisites) indegrees[cp[0]]++;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegrees[i] == 0) queue.addLast(i);
        }
        while(!queue.isEmpty()) {
            Integer pre = queue.removeFirst();
            numCourses--;
            for(int[] req : prerequisites) {
                if(req[1] != pre) continue;
                if(--indegrees[req[0]] == 0) queue.add(req[0]);
            }
        }
        return numCourses == 0;
    }
    /**
     * @Description：    深度优先算法      拓扑排序
     * @Params:         课程数目 numCourses     依附关系    prerequisites
     * @return:         是否可以实现
     * @author: Mr.Wang
     * @create: 0:28
     */
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        int[][] adjacency = new int[numCourses][numCourses];
        int[] flags = new int[numCourses];
        for(int[] cp : prerequisites)
            adjacency[cp[1]][cp[0]] = 1;        //  确立依存关系
        for(int i = 0; i < numCourses; i++){
            if(!dfs(adjacency, flags, i)) return false;
        }
        return true;
    }
    private boolean dfs(int[][] adjacency, int[] flags, int i) {
        if(flags[i] == 1) return false;
        if(flags[i] == -1) return true;
        flags[i] = 1;
        for(int j = 0; j < adjacency.length; j++) {
            if(adjacency[i][j] == 1 && !dfs(adjacency, flags, j)) return false;
        }
        flags[i] = -1;
        return true;
    }
}
