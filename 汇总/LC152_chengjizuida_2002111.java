package LeetCode.汇总;

public class LC152_chengjizuida_2002111 {

    public static void main(String args [] ) {

        LC152_chengjizuida_2002111 Solution = new LC152_chengjizuida_2002111();
        int ret = Solution.solution();
        System.out.println(ret);
    }

    public static int solution() {
        int[] nums = {-4,-3};
        int imax = 1;
        int imin = 1;
        int max = Integer.MIN_VALUE;
        for (int i = 0;i<nums.length; i++) {
            if (nums[i]<0){
                int temp =imax;
                imax = imin;
                imin = temp;
            }
            imax = Math.max( imax*nums[i], nums[i]);
            imin = Math.min( imin*nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }

}
