package LeetCode._review_200315;

import java.util.*;

public class LC133 {

    public Node cloneGraph(Node node) {
        if (node == null){
            return node;
        }
        HashMap<Node,Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.put(node,new Node(node.val,new ArrayList<>()));
        while (!queue.isEmpty()){
            Node n = queue.poll();
            for (Node neighbor : n.neighbors){
                if (!visited.containsKey(neighbor)){
                    visited.put(neighbor,new Node(neighbor.val,new ArrayList<>()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        return visited.get(node);
    }
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
