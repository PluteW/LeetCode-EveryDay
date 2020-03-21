package LeetCode._test;

public class GCD_200321 {
    /**
     * @Description：  获得两个数字的最大公约数
     *                      使用辗转相除法
     * @Params:     int m, int n  等待寻找公约数的两个数字
     * @return:     int ret 最大公约数
     * @author: Mr.Wang
     * @create: 20:43
    */
    public int getGCD(int n,int m){
        if (n<m){
            int temp = n;
            n = m;
            m = temp;
        }
        if(n%m == 0) return m;
        else {
            while (n%m > 0) {
                n = n % m;

                if (n < m) {
                    n = n + m;
                    m = n - m;
                    n = n - m;
                }

                if (n % m == 0) {
                    return m;
                }
            }
            return 0;
        }
    }

}
