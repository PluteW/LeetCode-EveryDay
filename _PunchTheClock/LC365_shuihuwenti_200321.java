package LeetCode._PunchTheClock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class LC365_shuihuwenti_200321 {


    /**
     * @Description：  DFS思想  穷举可能出现的问题
     *          水量变化只有增加 x 或者 y 或者是减少 x 或者是 y
     * @Params:     int n,int m  两个水壶的容积  int z  目标体积的水
     * @return:     boolean  ret  是否可以获得体积为 z 的水
     * @author: Mr.Wang
     * @create: 21:00
    */
    public boolean canMeasureWater(int x, int y, int z) {
        if (z < 0 || z > x + y) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            int n = q.poll();
            if (n + x <= x + y && set.add(n + x)) {
                q.offer(n + x);
            }
            if (n + y <= x + y && set.add(n + y)) {
                q.offer(n + y);
            }
            if (n - x >= 0 && set.add(n - x)) {
                q.offer(n - x);
            }
            if (n - y >= 0 && set.add(n - y)) {
                q.offer(n - y);
            }
            if (set.contains(z)) {
                return true;
            }
        }
        return false;
    }


    /**
     * @Description： 贝祖定理
     *          若a,b是整数,且gcd(a,b)=d，那么对于任意的整数x,y,ax+by都一定是d的倍数，
     *          特别地，一定存在整数x,y，使ax+by=d成立。
     * @Params:     int n,int m  两个水壶的容积  int z  目标体积的水
     * @return:     boolean  ret  是否可以获得体积为 z 的水
     * @author: Mr.Wang
     * @create: 20:32
    */
    public boolean canMeasureWater2(int x, int y, int z) {
        if(x+y<z) return false;
        if (x == 0 || y==0) return x==z||y==z;
        return z%getGCD(x,y) == 0;
    }
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
