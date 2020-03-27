package LeetCode.汇总;

public class LC914_kapaijishu_200327 {
    /**
     * @Description：  最大公约数法
     *          如果各个数字的计数的最大公约数
     * @Params: int[] deck  保存各个数字的数组
     * @return: boolean ret 是否可以分为每组数目大于等于2
     * @author: Mr.Wang
     * @create: 22:25
    */
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int c: deck)
            count[c]++;
        int g = -1;
        for (int i = 0; i < 10000; ++i)
            if (count[i] > 0) {
                if (g == -1)
                    g = count[i];
                else
                    g = gcd(g, count[i]);
            }

        return g >= 2;
    }

    public int gcd(int x, int y) {
        return x == 0 ? y : gcd(y%x, x);
    }
}
