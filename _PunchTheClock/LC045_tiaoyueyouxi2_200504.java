package LeetCode._PunchTheClock;

public class LC045_tiaoyueyouxi2_200504 {
    public static void main(String[] args) {
        LC045_tiaoyueyouxi2_200504 Sloution = new LC045_tiaoyueyouxi2_200504();
        int ret  = Sloution.jump(new int[]{8,2,4,4,4,9,5,2,5,8,8,0,8,6,9,1,1,6,3,5,1,2,6,6,0,4,8,6,0,3,2,8,7,6,5,1,7,0,3,4,8,3,5,9,0,4,0,1,0,5,9,2,0,7,0,2,1,0,8,2,5,1,2,3,9,7,4,7,0,0,1,8,5,6,7,5,1,9,9,3,5,0,7,5});
        System.out.println(ret);
    }

//     超时了，giao
    int min  = Integer.MAX_VALUE;
    int[] nums;
    public int jump(int[] nums) {
        this.nums = nums;
        helper(0,0);
        return min;
    }
    public void helper(int start,int step){
        if (step >= min)
            return;
        if (start >= nums.length-1) {
            this.min = Math.min(this.min, step);
            return;
        }
        for (int i = nums[start];i>0;i--){
            helper(start+i,step+1);
        }
    }

    public int jump2(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
