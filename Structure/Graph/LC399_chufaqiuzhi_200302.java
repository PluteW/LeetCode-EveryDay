package LeetCode.Structure.Graph;

import java.util.*;

public class LC399_chufaqiuzhi_200302 {
        //双向路径
        private Map<String, Map<String, Double>> cache = new HashMap<String, Map<String, Double>>();
        class Strdou {          //放入队列的元素，
            public String x;    //除数
            public Double val;  //当前值
            public Strdou(String xx, Double cc) {
                x = xx;
                val = cc;
            }
        }
    public double[] solution(List<List<String>> equations, double[] values, List<List<String>> queries){
        if (queries.size() == 0) {  //别算了
            return null;
        }
//        先将数据保存到Map中，方便后面的查找
//        这里将正向除和反向除都进行了保存，所以在后面调用的时候就可以直接使用乘法进行处理
//        结合定义的结构进行比较和分析
        for (int i = 0; i < equations.size(); i++) {
            String first = equations.get(i).get(0);
            String second = equations.get(i).get(1);
            //保存正向的路径    a / b
            if (cache.containsKey(first)) {
                cache.get(first).put(second, values[i]);
            }
            else {
                Map<String, Double> c = new HashMap<String, Double>();
                c.put(second, values[i]);
                cache.put(first, c);
            }
            //保存逆向的路径    b / a
            if (cache.containsKey(second)) {
                cache.get(second).put(first, 1.0 / values[i]);
            }
            else {
                Map<String, Double> c = new HashMap<String, Double>();
                c.put(first, 1.0 / values[i]);
                cache.put(second, c);
            }
        }

        double[] res = new double[queries.size()];      // 初始化话保存结果的数组

        for (int i = 0; i < res.length; i++) {
            res[i] = BFS(queries.get(i));
        }
        return res;
    }
    /**
     * @Description：  广度优先算法  BFS
     * @Params: List<String> 保存着需要进行计算的方程式
     * @return: double 查找结果，如果没能计算出结果，则直接返回
     * @author: Mr.Wang
     * @create: 23:12
    */
        private double BFS(List<String> query){

            if (!cache.containsKey(query.get(0))||!cache.containsKey(query.get(1))) { //不可达
                return -1.0;
            }
            if (query.get(0).equals(query.get(1))) {    //相等返回1
                return 1.0;
            }
            Queue<Strdou> que = new LinkedList<Strdou>();
            Set<String> paths = new HashSet<String>();  //记录已经走过的点
            que.offer(new Strdou(query.get(0), 1.0));
            paths.add(query.get(0));

            while (!que.isEmpty()) {
                Strdou s = que.poll();
                Map<String, Double> c = cache.get(s.x);
                //从key点开始遍历周围的点
                for (String key : c.keySet()) {
                    if (paths.contains(key)) {
                        continue;
                    }
                    paths.add(key);//标记走过
                    que.offer(new Strdou(key, s.val * c.get(key)));
                    if (key.equals(query.get(1))) {
                        return s.val * c.get(key);
                    }
                }
            }
            return -1.0;
        }
}
