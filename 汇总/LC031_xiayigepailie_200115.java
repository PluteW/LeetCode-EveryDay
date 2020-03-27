package LeetCode.汇总;

public class LC031_xiayigepailie_200115 {

    public static void main(String args[] ) {
        int[] ret = solution();
        for (int i = 0; i<ret.length;i++){
            System.out.println(ret[i]);
        }

    }

    public static int[] solution() {
        int[] nums = new int[]{1,2,3};      //示例数组

        for (int i = nums.length -2 ; i> -1;i--) {
            if (nums[i+1] > nums[i]){
                for (int j = nums.length-1; j>i;j--){
                    if (nums[j] > nums[i]) {
                        swap(nums,i,j);
                        reverse(nums,i+1);
                        return nums;
                    }
                }
            }
        }
        reverse(nums,0);

        return nums;
    }
//    用于交换位置 i 与 j 两个位置的元素
    public static void swap( int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
//    用于将数组倒序排列
    public static void reverse( int[] nums, int i){
        int j = nums.length-1;
        while (i < j){
            swap(nums,i,j);
            i++;
            j--;
        }
    }

}
