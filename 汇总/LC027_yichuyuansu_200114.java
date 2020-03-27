package LeetCode.汇总;

public class LC027_yichuyuansu_200114 {

    public static void main(String args[]) {
        int len  = solution();
        System.out.println(len);
    }

    public static int solution() {

        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        int i = 0;
        for (int j = 0; j < nums.length; j++){
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        return i;
    }
}
