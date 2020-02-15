package LeetCode.ShuZu;

public class LC033_sousuoxuanzhuanpaixushuzu_200116 {


    public static void main(String args[]) {

        int ret = solution();
        System.out.println(ret);

    }

    public static int solution(){

        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        int rotate_index = 0;

        if (nums.length == 0)
            return -1;
        if ( nums.length == 1)
            return nums[0] == target ? 0 : -1;

        for (int i = 1;i<nums.length;i++){
            if (nums[i] < nums[i-1]) {
                rotate_index = i;
                break;
            }
        }

        // if target is the smallest element
        if (nums[rotate_index] == target)
            return rotate_index;
        // if array is not rotated, search in the entire array
        if (rotate_index == 0)
            return search(nums,target,0, nums.length-1);
        if (target < nums[0])
            // search in the right side
            return search(nums,target,rotate_index, nums.length-1);
        // search in the left side
        return search(nums,target,0, rotate_index);

    }
    public static int search(int[] nums,int target,int i,int j){

        while (i<=j){
            int middle = (i+j)/2;
            if (target == nums[middle]) {
                return middle;
            } else {
                if (target>nums[middle]){
                    i = middle;         //////////////////////
                } else {
                    j = middle;         //////////////////////
                }
            }
        }
        return -1;
    }
}
