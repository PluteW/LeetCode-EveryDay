package LeetCode.PunchTheClock;

public class LC1013_shuzudengfen_200311 {
    public static void main(String[] args) {
        LC1013_shuzudengfen_200311 Solution = new LC1013_shuzudengfen_200311();
        boolean ret = Solution.solution();
        System.out.println(ret);
    }

    /**
     * @Description： 借助计数的方法
     * @Params: int[] A 保存数据的数组
     * @return: boolean ret 是否可以返回为三个和相同的子数组
     * @author: Mr.Wang
     * @create: 22:25
    */
    public boolean solution(){
        int[] A = {0,2,1,-6,6,-7,9,1,2,0,1};
        int len=A.length-1;
        for(int i=1;i<=len;++i){
            A[i]+=A[i-1];
        }
        if(A[len]%3!=0)return false;        // 如果和不是三的倍数，说明这一定不可能是某个数字的三倍
        int eqsum=A[len]/3,times=1;
        for(int i=0;i<len && times<3;++i){
            if(A[i]==eqsum*times)++times;
        }
        return times==3;
    }

}
