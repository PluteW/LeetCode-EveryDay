package LeetCode.Structure.ZiFuChuan;

import java.util.*;

public class LC049_zimuyiwei_200131 {
    public static void main(String args[]) {
        LC049_zimuyiwei_200131 Solution = new LC049_zimuyiwei_200131();
        List ret = Solution.solution2();
        System.out.print(ret);
    }
//  解法 1 ：

    /**
     * 使用 Map 来保存
     * 使用排序后的字符串作为Key 值，将其他的字符串作为结果添加到后面
     **/
    public List solution() {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        if (strs.length == 0)
            return new ArrayList();

        Map<String, List> ret = new HashMap<String, List>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            if (!ret.containsKey(str))
                ret.put(str, new ArrayList());
            ret.get(str).add(s);
        }
        return new ArrayList(ret.values());
    }
//  对出现的字母的数字进行计数

    /***
     *  整体仍然使用 Map 进行计数
     *  键值 Key 使用数字的连串来记录
     *  Value保存记录各个数量的子串
     *
     * */
    public List solution2() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        if (strs.length == 0)
            return new ArrayList();
        Map<String, List> ret = new HashMap<String, List>();
        int[] nums = new int[26];

        for (String s : strs) {
            Arrays.fill(nums, 0);
            for (char c : s.toCharArray()) {
                nums[c - 'a']++;
            }
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : nums) {
                stringBuilder.append(i);
            }
            String str = stringBuilder.toString();
            if (!ret.containsKey(str))
                ret.put(str, new ArrayList());
            ret.get(str).add(s);

        }
        return new ArrayList(ret.values());
    }
}
