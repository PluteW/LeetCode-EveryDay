package LeetCode._review_200315;

public class LC264 {
    public int nthUglyNumber(int n) {
        double[] ret = new double[n];
        ret[0] = 1;
        int i2 = 0,i3 = 0,i5 = 0;
        for (int i = 1;i<n;i++) {
            double min = Math.min(ret[i2]*2, Math.min(ret[i3]*3,ret[i5]*5));
            ret[i] = min;
//            下列写法不能够过滤掉重复数值
//            if (min == ret[i2]*2) i2++;
//            else if (min == ret[i3] *3) i3++;
//            else i5++;
            if (min == ret[i2] * 2) i2++;
            if (min == ret[i3] * 3) i3++;
            if (min == ret[i5] * 5) i5++;
        }
        return (int)ret[n-1];
    }
}
