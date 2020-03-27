package LeetCode.汇总;

public class LC004_zhongweishu_answeer_200109 {

    public static void main(String[] args) {

        double res = solution();
        System.out.println(res);

    }

    public static double solution() {
        //原始数据
        int[] a = {2,4,7,9};
        int[] b = {1,5,8,10,14};

        int len_a = a.length;
        int len_b = b.length;

        if (len_a > len_b) { // to ensure m<=n
            int[] temp = a;
            a = b;
            b = temp;
            int tmp = len_a;
            len_a = len_b;
            len_b = tmp;
        }

        int i_Min = 0;
        int i_Max = len_a;
        int half_length = (len_a + len_b ) / 2;      // +1的目的是？

        while (i_Max >= i_Min) {
            int i = (i_Max + i_Min) / 2;
            int j = half_length - i;
            /**
             * 使用左侧的最大值与右侧的最小值进行比较
             *  同时需要保证：
             *      i 的范围仍然在第一个数组的有效范围内，即 i_Min < i < i_Max
             *  由于两者不会同时成立，故使用else if
             * **/
            if (i > i_Min && a[i - 1] > b[j]) {        //a组左边组的最大值已经大于右组的最小值，说明a组的划分点偏大
                i_Max--;
            } else if (i < i_Max && a[i] < b[j - 1]) {        //a组右边组的最大值已经小于左组的最大值，说明a组的划分点偏小
                i_Min++;
            } else {
                /**
                 *  满足了左右两个数组的数量相等了，此时就是满足条件的情况
                 *  输出过程需要区分两个数组中数字总个数的区别
                 *      如果两个数组的数字总数为奇数，则输出的中位数即交界位置的两个数中偏小的一个
                 *      如果两个数组的数字总数为偶数，则输出的中位数就是交界位置的两个值的平均值
                 *                          交界位置的两个值分别为左侧的最大值和右侧的最小值
                 *      特别的，考虑边界条件：
                 *          如果说第一组的数据全部是在左侧的组里，也就是最后 i == len_a的情况，
                 *          此时返回的值一定在第二组数据中，剩下的就是根据奇偶的问题来返回
                 *          如果说第一组数据全部在右侧的组里，也就是说最后 i == 0的情况，
                 *          此时返回的值依然是一定在第二组数据中，返回的结果根据奇偶性来判断
                 *          同理判断第二个数据源
                 * **/

                int max_Left = 0;
                if (i == 0) max_Left = b[j - 1];
                else if (j == 0) max_Left = a[i - 1];
                else {
                    max_Left = Math.max(a[i - 1], b[j - 1]);
                }
                if ((len_a + len_b) % 2 == 1) {      //如果是奇数，返回交界点的小值
                    return max_Left;
                }

                    int min_Right = 0;
                    if (i == len_a) min_Right = b[j];
                    else if (j == len_b) min_Right = a[i];
                    else {
                        min_Right = Math.min(a[i], b[j]);
                    }

                    if ((len_a + len_b) % 2 == 1) {      //如果是奇数，返回交界点的小值
                        return Math.min(max_Left, min_Right);
                    } else {
                        return (double) (min_Right + max_Left) / 2;
                    }
                }
            }
        return 0.0;
    }
//    官方的代码
        public static double solution2(){
            int[] A = {};
            int[] B = {1};
            int m = A.length;
            int n = B.length;
            if (m > n) { // to ensure m<=n
                int[] temp = A;
                A = B;
                B = temp;
                int tmp = m;
                m = n;
                n = tmp;
            }
            int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
            while (iMin <= iMax) {
                int i = (iMin + iMax) / 2;
                int j = halfLen - i;
                if (i < iMax && B[j - 1] > A[i]) {
                    iMin = i + 1; // i is too small
                } else if (i > iMin && A[i - 1] > B[j]) {
                    iMax = i - 1; // i is too big
                } else { // i is perfect
                    int maxLeft = 0;
                    if (i == 0) {
                        maxLeft = B[j - 1];
                    } else if (j == 0) {
                        maxLeft = A[i - 1];
                    } else {
                        maxLeft = Math.max(A[i - 1], B[j - 1]);
                    }
                    if ((m + n) % 2 == 1) {
                        return maxLeft;
                    }

                    int minRight = 0;
                    if (i == m) {
                        minRight = B[j];
                    } else if (j == n) {
                        minRight = A[i];
                    } else {
                        minRight = Math.min(B[j], A[i]);
                    }

                    return (maxLeft + minRight) / 2.0;
                }
            }
            return 0.0;
        }


        public static double solution3(){

            int[] A = {};
            int[] B = {1};
            int la = A.length;//数组 A 的长度
            int lb = B.length;//数组 B 的长度

            if (la > lb) {//如果数组 A 比较长，则交换 A、B 数组
                int[] temp = A;
                A = B;
                B = temp;

                int tempL = la;
                la = lb;
                lb = tempL;
            }

            int aMin = 0;     //A 数组折半查找左边界
            int aMax = la;    //A 数组折半查找右边界

            // halfLen 的作用就是中点坐标，当 A 数组中折半查找向右移动时，B 数组以 halfLen 为相对点向左移动，以保持始终均分
            int halfLen = (la + lb + 1) >> 1;
            //二分查找

            //情况一: A 数组为空，中位数在 B 数组
            //情况二: A 数组较短
            //  1) A 数组元素都较小，中位数在B数组
            //  2) A 数组元素都较大，中位数在B数组
            //  3) A、B 元素大小分布基本相当，中位数为被分割的两数组左半部分较大的那一个和右半部分较小的那一个之和的一半
            //情况三: A、B 等长
            //  1) A 数组元素都比B数组元素小，中位数为 A 数组尾元素和B数组首元素之和的一半
            //  2) B 数组元素都比A数组元素小，中位数为 B 数组尾元素和A数组首元素之和的一半
            //  3) A、B 元素大小分布基本相当，中位数为被分割的两数组左半部分较大的那一个和右半部分较小的那一个之和的一半
            while (aMin <= aMax) {
                int aIndex = (aMin + aMax) >> 1;  //A数组中分割点
                int bIndex = halfLen - aIndex;  //B数组中分割点

                //数组 A 分割点相邻左边那个元素比数组 B 分割点相邻右边那个元素大，则应该将数组 A 分割点向右移，数组 B 分割点向左移
                //数组 A 分割点有向左移趋势，需检查左边界
                if (aIndex > aMin && A[aIndex - 1] > B[bIndex]) {
                    aMax = aIndex - 1;
                    //数组 A 分割点相邻右边那个元素比数组 B 分割点相邻左边那个元素大，则应该将数组 A 分割点向左移，数组 B 分割点向右移
                    //数组 A 分割点有向右移趋势，需检查右边界
                } else if (aIndex < aMax && B[bIndex - 1] > A[aIndex]) {
                    aMin = aIndex + 1;
                    //得出结果
                } else {

                    int leftPart = 0;
                    //情况一,情况二2，情况三2
                    if (aIndex == 0) {
                        leftPart = B[bIndex-1];
                        //情况三1
                    } else if (bIndex == 0) {
                        leftPart = A[la - 1];
                        //情况二1,情况二3,情况三3
                    } else {
                        leftPart = Math.max(A[aIndex - 1], B[bIndex-1]);
                    }

                    //元素个数总和为奇数
                    if ((la + lb) % 2 == 1) {
                        return leftPart;
                    }

                    //情况一: A 数组为空，中位数在 B 数组
                    //情况二: A 数组较短
                    //  1) A 数组元素都较小，中位数在B数组
                    //  2) A 数组元素都较大，中位数在B数组
                    //  3) A、B 元素大小分布基本相当，中位数为被分割的两数组左半部分较大的那一个和右半部分较小的那一个之和的一半
                    //情况三: A、B 等长
                    //  1) A 数组元素都比B数组元素小，中位数为 A 数组尾元素和B数组首元素之和的一半
                    //  2) B 数组元素都比A数组元素小，中位数为 B 数组尾元素和A数组首元素之和的一半
                    //  3) A、B 元素大小分布基本相当，中位数为被分割的两数组左半部分较大的那一个和右半部分较小的那一个之和的一半

                    //元素个数总和为偶数
                    int rightPart = 0;
                    //情况一,情况二1
                    if (aIndex == la) {
                        rightPart = B[bIndex];
                        //情况三2
                    } else if (bIndex == lb) {
                        rightPart = A[0];
                        //情况二2、3，情况三1、3
                    }else {
                        rightPart = Math.min(A[aIndex], B[bIndex]);
                    }
                    return (leftPart + rightPart) / 2.0;
                }

            }
            return 0;
        }
}