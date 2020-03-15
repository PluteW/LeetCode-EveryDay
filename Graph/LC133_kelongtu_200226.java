package LeetCode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class LC133_kelongtu_200226 {

    public static void main(String[] args) {
        LC133_kelongtu_200226 Solution = new LC133_kelongtu_200226();
    }
    /**
     * @Description： 方法一 ：深度优先算法
     * @Params: 需要被复制的节点 Node
     * @return: 复制过后的节点 Node
     * @author: Mr.Wang
     * @create: 22:30
    */
    private HashMap<Node,Node> visited = new HashMap<>();
    public Node cloneGraph(Node n){
        if (n == null){
            return n;
        }
        if (visited.containsKey(n)){
            return visited.get(n);
        }
        Node cloneNode = new Node(n.val,new ArrayList<>());
        visited.put(n,cloneNode);
        for (Node neighbor:n.neighbors){
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
    /**
     * @Description： 方法2： 广度优先算法
     * @Params: 需要被复制的节点
     * @return: 复制完成的一个节点
     * @author: Mr.Wang
     * @create: 22:45
    */
    public Node cloneGraph2(Node n){
        if (n == null){
            return n;
        }
        HashMap<Node,Node> visited = new HashMap<>();
        LinkedList<Node> queue = new LinkedList<Node>();
        queue.add(n);
        visited.put(n, new Node(n.val, new ArrayList()));
        while (!queue.isEmpty()){
            Node node = queue.remove();
            for (Node neighbor : node.neighbors){
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(node).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(n);
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
