package LeetCode.汇总;

public class LC004_zhongweishu_200101 {

    public static double main(String args[]) {

        int[] a = new int[10];
        int[] b = new int[10];

        int len_a = a.length;
        int len_b = b.length;

        if (len_a < len_b) {
            int[] temp = a;
            a = b;
            b = temp;
            int len_tem = len_a;
            len_a = len_b;
            len_b = len_tem;
        }

        int i_Min = 0;
        int i_Max = len_a;
        int halfLength = (len_a + len_b + 1) / 2;
        while (i_Min <= i_Max) {
            int i = (i_Max + i_Min) / 2;
            int j = halfLength - i;

            if (i > i_Min && a[i - 1] > b[j]) {
                i_Min++;
            } else if (i < i_Max && a[i] < b[j - 1]) {
                i_Max--;
            } else {
                int max_left = 0;
                int min_right = 0;

                if (i == 0) max_left = b[j - 1];
                else if (j == 0) max_left = a[i - 1];
                else max_left = Math.max(a[i - 1], b[j - 1]);

                if ((len_a + len_b) % 2 == 1) return max_left;

                if (i == len_a) min_right = b[j];
                else if (j == len_b) min_right = a[i];
                else {
                    min_right = Math.min(a[i], b[j]);

                }

                return (max_left + min_right) / 2.0;
            }
        }
        return 0.0;
    }
}
