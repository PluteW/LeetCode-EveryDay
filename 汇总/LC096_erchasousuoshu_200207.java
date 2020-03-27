package LeetCode.汇总;


public class LC096_erchasousuoshu_200207 {
    public static void main(String args[]) {

        LC096_erchasousuoshu_200207 Solution = new LC096_erchasousuoshu_200207();
        int ret = Solution.solution();
        System.out.println(ret);

    }

    /**
     * @Description： 动态规划  大的树一定是由小子树构建起来的
     * @Params: int n 节点个数
     * @return: int ret 最多有多少中排列的可能性
     * @author: Mr.Wang
     * @create: 22:36
    */
    public int solution(){
        int n = 3;
        int[] ret = new int[n+1];
        ret[0] = 1;
        ret[1] = 1;

        for (int i = 2;i<=n;i++){
            for (int j = 1;j<=i;j++){
                ret[i] += ret[j-1] * ret[i-j];
            }
        }
        return ret[n];
    }
}
