package LeetCode.汇总;

public class LC376_baidongxulie_200324 {
    public static void main(String[] args) {
        int[] nums = {1,1,7,4,9,2,5};
        int ret = new LC376_baidongxulie_200324().wiggleMaxLength(nums);
        System.out.println(ret);
    }

    /**
     * @Description：  使用了标志符的思想
     * @Params:     int[] nums  待判断数组
     * @return:     int  ret 震荡的最大数量
     * @author: Mr.Wang
     * @create: 23:23
    */
    public int wiggleMaxLength(int[] nums) {
        if (nums.length<2) return nums.length;
        boolean up = true;
        int counter = 1;
        if (nums[0] == nums[1]) counter = 1;
        int tem = nums[0];
        for (int i = 1;i<nums.length;i++){
            if (nums[i] == tem)
                continue;
            if (counter == 1)
                up = nums[i]>tem?false:true;
            if (up){
                if (nums[i] < tem) {
                    counter++;
                    up = !up;
                }
                tem = nums[i];
            }else {
                if (nums[i] > tem) {
                    counter++;
                    up = !up;
                }
                tem = nums[i];
            }
        }
        return counter;
    }
}
