package LeetCode.DP;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC139_dancichaifen_200110 {

    public static void main(String args[]) {

        LC139_dancichaifen_200110 Solution = new LC139_dancichaifen_200110();
        boolean ret= Solution.solution();
        System.out.println(ret);
    }
//  方法 1 ： 动态规划法
    public boolean solution() {
        String[] wordDict = { "cats", "dog", "sand", "and", "cat"};
        Set<String> wordDictSet=new HashSet();
        for (int i = 0;i < wordDict.length;i++) {
            wordDictSet.add(wordDict[i]);
        }
        String s = "catsandog";

        boolean[] ret = new boolean[s.length()+1];
        ret[0] = true;
        for (int i = 1;i<ret.length;i++){
            for (int j = 0;j<i;j++){
                if (ret[j] && wordDictSet.contains(s.substring(j,i))){
                    ret[i] = true;
                    break;
                }
            }
        }
        return ret[s.length()];
    }

//    方法 2 ：宽度优先算法
    /**
     * 将字符串可视化成一棵树，每一个节点是用 endend 为结尾的前缀字符串。
     * 当两个节点之间的所有节点都对应了字典中一个有效字符串时，两个节点可以被连接。
     * 为了形成这样的一棵树，我们从给定字符串的第一个字符开始（比方说 ss ），将它作为树的根部，
     * 开始找所有可行的以该字符为首字符的可行子串。
     * 进一步的，将每一个子字符串的结束字符的下标（比方说 ii）放在队列的尾部供宽搜后续使用。
     * */
    public boolean solution2() {
        String[] wordDict = { "cats", "dog", "sand", "and", "cat"};
        Set<String> wordDictSet=new HashSet();
        for (int i = 0;i < wordDict.length;i++) {
            wordDictSet.add(wordDict[i]);
        }
        String s = "catsandog";

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordDictSet.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }

}
