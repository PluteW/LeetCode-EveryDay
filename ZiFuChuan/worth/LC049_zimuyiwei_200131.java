package LeetCode.ZiFuChuan.worth;

import java.util.*;

public class LC049_zimuyiwei_200131 {
    public static void main(String args[]) {
        LC049_zimuyiwei_200131 Solution = new LC049_zimuyiwei_200131();
        List ret = Solution.solution();
        System.out.print(ret);
    }

    public List solution() {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map<String,List> ret = new HashMap<String, List>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if (!ret.containsKey(str))
                ret.put(str,new ArrayList());
            ret.get(str).add(s);

        }
        return new ArrayList(ret.values());
    }

}
