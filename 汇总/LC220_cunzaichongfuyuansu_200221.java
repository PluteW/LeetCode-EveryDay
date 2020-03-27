package LeetCode.汇总;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LC220_cunzaichongfuyuansu_200221 {

    public static void main(String[] args) {
        LC220_cunzaichongfuyuansu_200221 Solution = new LC220_cunzaichongfuyuansu_200221();
        boolean ret = Solution.solution();
        System.out.println(ret);
    }

/**
 *      方法一： 借助自平衡树来方便查找和添加
 *      树的大小为 k 保持窗口大小为 k
 *      使用java的ceiling和floor函数来分别获得最靠近当前考察值的值
 * */
    public boolean solution() {
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            Integer ceiling = treeSet.ceiling(nums[i]);
            if (ceiling != null & ceiling - nums[i] <= t)
                return true;
            Integer floor = treeSet.floor(nums[i]);
            if (floor != null & nums[i] - floor <= t)
                return true;
            treeSet.add(nums[i]);
            if (treeSet.size() > k) {
                treeSet.remove(nums[i - k]);
            }
        }
        return false;
    }

/**
 *      方法2： 桶排序
 * */
    public boolean solution2(){
        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
    private long getID(long x, long w) {
        return x < 0 ? (x + 1) / w - 1 : x / w;
    }
}
