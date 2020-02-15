package LeetCode.ShuZu;

public class LC011_zuidarongqi_answer_200109 {

    public static void main(String args []) {

    }

    /**
     *      官方解法 1 ：
     *      暴力法
     *
     *          时间复杂度：n^2
     *          空间复杂度：1
     *
     * **/
    public static int solution1() {
        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxarea = 0;
        for (int i = 0; i < height.length; i++)
            for (int j = i + 1; j < height.length; j++)
                maxarea = Math.max(maxarea, Math.min(height[i], height[j]) * (j - i));
        return maxarea;
    }

    /**
     *      官方解法 2 ：
     *      双指针法
     *
     *          时间复杂度 ： n
     *          空间复杂度 ： 1
     *
     *      算法理解：
     *          在由线段长度构成的数组中使用两个指针，一个放在开始，一个置于末尾。
     *          此外，我们会使用变量 maxarea 来持续存储到目前为止所获得的最大面积。
     *          在每一步中，我们会找出指针所指向的两条线段形成的区域，更新 maxareamaxarea，
     *          并将指向较短线段的指针向较长线段那端移动一步。
     *
     * **/

    public static int solution2() {

        int[] height = {1,8,6,2,5,4,8,3,7};
        int maxarea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxarea;
    }

}
