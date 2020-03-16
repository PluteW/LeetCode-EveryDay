package LeetCode.Structure.ShuZu;

public class LC034_chazhaoyuansufanwei_200117 {


    public static void main(String args[]) {

        int[] ret = solution2();
        System.out.println(ret[0]);
        System.out.println(ret[1]);

    }
//  自己写的遍历法来求范围
    public static int[] solution1() {

        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        int[] range = new int[]{-1,-1};

        boolean first = false;
        for (int i = 0;i<nums.length;i++){
            if (!first & nums[i] == target){
                range[0] = i;
                range[1] = i;
                first = true;
            }
            if (first && nums[i] == target){
                range[1] = i;
            }
        }

        return range;
    }
//     官方给出的遍历方法求取范围
//      相比之下，官方给出的求取的时间复杂度更低
//      （原因是避免了在范围内部的遍历的数据更新，而是直接拿到了范围两端的位置）
    public static int[] solution2 () {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] range = new int[]{-1,-1};

        for (int i = 0;i<nums.length ; i++){
            if (nums[i] == target) {
                range[0] = i;
                break;
            }
        }
        if (range[0] == -1){
            return range;
        }else {
            for (int j = nums.length-1;j>-1;j--){
                if (nums[j] == target ){
                    range[1] = j;
                    return range;
                }
            }
        }
        return range;
    }

}
