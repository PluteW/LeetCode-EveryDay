package LeetCode.Structure.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC310_zuixiaogaodushu_200229 {
    public static void main(String[] args) {
        LC310_zuixiaogaodushu_200229 Solution = new LC310_zuixiaogaodushu_200229();
        List<Integer> ret = Solution.solution();
        System.out.println(ret);
    }
    /**
     * @Description： 使用广度优先算法   BFS
     * @Params: 节点个数 n  边的列表  edges
     * @return:  最小高度树的根节点，至多两个
     * @author: Mr.Wang
     * @create: 22:44
    */
    public List<Integer> solution(){
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> minHeightTreeToot = new ArrayList<>();
//        特判
        if (n == 1) {
            minHeightTreeToot.add(0);
            return minHeightTreeToot;
        }
        int first,second;
        int[] degree = new int[n];      //记录入度
//        初始化邻接表
        List<List<Integer>>adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }
//        初始化邻接表完成
//        将边的信息同步到邻接表与入度表中
        for (int[] cur : edges) {
            first = cur[0];
            second = cur[1];
            degree[first]++;
            degree[second]++;
            adjacencyList.get(first).add(second);
            adjacencyList.get(second).add(first);
        }
//        初始化队列，用于进行压队列
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 1) {
                queue.add(i);
            }
        }
        List<Integer> neighbors;
        int size, curNode;
        while (!queue.isEmpty()) {
            size = queue.size();
            minHeightTreeToot.clear();
            for (int j = 0; j < size; j++) {
                curNode = queue.poll();     // 取出队列中第一个节点（入度一定为1）
                minHeightTreeToot.add(curNode);
                neighbors = adjacencyList.get(curNode);     // 取出对应的邻居节点列表
                for (int neighbor : neighbors) {
                    degree[neighbor]--;                     // 移除前，邻居节点入度减一
                    if (degree[neighbor] == 1) {
                        queue.add(neighbor);
                    }
                }
            }
        }
        return minHeightTreeToot;
    }
}
