package LeetCode.汇总;

public class LC026_shanchuchongfuxiang_200114 {

    public static void main(String args[] ) {
        int len = solution();
        System.out.println(len);

    }

    public static int solution () {

        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};

        if (nums.length == 1 | nums.length == 0) {
            return nums.length;
        }
        int i = 0;
        for (int j = 1;j < nums.length; j++) {
            if ( nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i+1;
    }

}
