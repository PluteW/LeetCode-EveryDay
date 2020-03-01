package LeetCode.Graph;

import java.util.*;

public class LC332_chongxinaipaixingcheng_200301 {
    public static void main(String[] args) {

    }
    /**
     * @Description： 深度优先算法
     * @Params:   输入为二维List 代表机票的航班信息
     * @return:   行程的正确顺序
     * @author: Mr.Wang
     * @create: 23:11
    */
    public List<String> solution(){
       List<List<String>> tickets = null;   // 参数格式 [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> ticket:tickets){
            PriorityQueue<String> neighbor = map.computeIfAbsent(ticket.get(0),k->new PriorityQueue<>());
            neighbor.offer(ticket.get(1));
        }
        List<String> result = new LinkedList<>();
        dfs(map,"JFK",result);
        return result;
    }

    public void dfs(Map<String,PriorityQueue<String>> map,String src,List<String> result){
        PriorityQueue<String> queue=map.get(src);
        while(queue!=null&&queue.size()>0){
            String poll = queue.poll();
            dfs(map,poll,result);
        }
        result.add(0,src);
    }
}
