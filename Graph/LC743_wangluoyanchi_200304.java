package LeetCode.Graph;

import java.util.*;

public class LC743_wangluoyanchi_200304 {
    public static void main(String[] args) {
        LC743_wangluoyanchi_200304 Solution = new LC743_wangluoyanchi_200304();
        int ret = Solution.solution();
        System.out.println(ret);
    }

    /**
     * @Description：  方法一：深度优先算法
     * @Params:  times 保存的是从第 1 个点到第 N 个点中，部分的连接时间
     *           N 点的总数目 （ 从 1 开始标号，标到 N
     *           第一个被通知的点的代号 K
     * @return:  通知所有点所需要的最长时间，若无法通知到所有的点，则返回 -1
     * @author: Mr.Wang
     * @create: 23:17
    */
    Map<Integer,Integer> result;
    public int solution(){
        int[][] times = new int[10][3];
        int N = 50;
        int K = 1;
        Map<Integer, List<int[]>> map = new HashMap<>();
//        先将所有的时间延迟压入邻接表中
        for (int i = 0;i<times.length;i++){
            if (!map.containsKey(times[i][0]))
                map.put(times[i][0],new ArrayList<int[]>());
            map.get(times[i][0]).add(new int[]{times[i][2],times[i][1]});
        }
//        对邻接表中的数据，按照延时从短到长进行排序
        for (int key: map.keySet()){
            Collections.sort(map.get(key),(a,b)-> a[0]- b[0]);
        }
//        初始化保存结果的Map
        result = new HashMap<>();
        for (int i=1;i<=N;i++){
            result.put(i,Integer.MAX_VALUE);
        }
//        将保存了邻接表和要通知的点以及当前的时间发入深度优先检索
        dfs(map,K,0);
        int ret = 0;
//        如果有的点的时间仍然是无限长，那就说明有的点无法访问到
        for (int cand: result.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ret = Math.max(ret, cand);
        }
        return ret;

    }
    public void dfs(Map<Integer,List<int[]>> map, int node, int time){
//        比较当前传来的时间是不是比之前传来的长，长的话，就没有必要继续接收了
        if (result.get(node) <= time)   return;
//        如果接收了，那就更新从这个点可到的所有点的时延长短
        result.put(node,time);
        if (map.containsKey(node)){
            for (int[] info : map.get(node)){
                dfs(map,info[1],time+info[0]);
            }
        }
    }

    
    /**
     * @Description： 方法二：迪克斯塔拉算法  贪心算法
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 23:30
    */
    Map<Integer, Integer> dist;
    public int solution2(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
//        初始化保存结果的数组
        dist = new HashMap();
        for (int node = 1; node <= N; ++node)
            dist.put(node, Integer.MAX_VALUE);
//        将第一个要考察的值压入Map中
        dist.put(K, 0);
//        用于保存当下的节点是否考察过
        boolean[] seen = new boolean[N+1];
        while (true) {
            int candNode = -1;
            int candDist = Integer.MAX_VALUE;
            for (int i = 1; i <= N; ++i) {
//                取没有被访问过且有初始值的点    也就是上面初始化的那个位置
                if (!seen[i] && dist.get(i) < candDist) {
                    candDist = dist.get(i);
                    candNode = i;
                }
            }
            if (candNode < 0) break;    // 小于零就说明没有找到合适的点
            seen[candNode] = true;
            if (graph.containsKey(candNode))
                for (int[] info: graph.get(candNode))
                    dist.put(info[0],
                            Math.min(dist.get(info[0]), dist.get(candNode) + info[1]));
        }
        int ans = 0;
        for (int cand: dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, cand);
        }
        return ans;
    }
    
    /**
     * @Description： 方法三：借助堆
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 23:33
    */
    public int solution3(int[][] times, int N, int K) {
        Map<Integer, List<int[]>> graph = new HashMap();
        for (int[] edge: times) {
            if (!graph.containsKey(edge[0]))
                graph.put(edge[0], new ArrayList<int[]>());
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
//        按照连接点进行排序
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                (info1, info2) -> info1[0] - info2[0]);
        heap.offer(new int[]{0, K});

        Map<Integer, Integer> dist = new HashMap();

        while (!heap.isEmpty()) {
            int[] info = heap.poll();
            int d = info[0], node = info[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, d);
            if (graph.containsKey(node))
                for (int[] edge: graph.get(node)) {
                    int nei = edge[0], d2 = edge[1];
                    if (!dist.containsKey(nei))
                        heap.offer(new int[]{d+d2, nei});
                }
        }

        if (dist.size() != N) return -1;
        int ans = 0;
        for (int cand: dist.values())
            ans = Math.max(ans, cand);
        return ans;
    }
}
