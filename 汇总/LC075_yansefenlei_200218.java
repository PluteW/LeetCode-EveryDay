package LeetCode.汇总;

public class LC075_yansefenlei_200218 {

    public static void main(String[] args) {
        LC075_yansefenlei_200218 Solution = new LC075_yansefenlei_200218();
        int[] ret = Solution.solution();
        System.out.println(ret);
    }

//    荷兰旗问题，也叫三色问题
    /**
     *      第一，循环的判断条件，应当为 p <= p2
     *      第二，判断何时进行游标移动
     *             游标 p 之前的元素已经都考察过了，所以更换后不必进行再次考察
     *             如果是从 2 的范围上换值过来的，则需要进行进一步的考量。
     * */
    public int[] solution(){
        int[] nums = {2,0,1};
        int p0 = 0;
        int p2 = nums.length-1;
        int p = 0;
        while (p <= p2){
            if (nums[p] == 2){
                swap(nums,p,p2);
                p2--;
            }else if (nums[p] == 0){
                swap(nums,p,p0);
                p++;
                p0++;
            }else{
                p++;
            }
        }
        return nums;
    }
    public void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
