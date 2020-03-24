package LeetCode.Arithmetic.Greed;

public class LC134_jiayouzhan_200324 {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        LC134_jiayouzhan_200324 Solution = new LC134_jiayouzhan_200324();
        int ret = Solution.canCompleteCircuit(gas,cost);
        System.out.println(ret);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int miles = 0;
        int gases = 0;
        for(int i = 0;i<gas.length;i++){
            gases += gas[i];
            miles += cost[i];
        }
        if (miles> gases)
            return -1;
        int remain = 0;
        for (int i = 0;i<gas.length;i++){
            remain = gas[i];
            for (int j = 0;j<gas.length;j++){
                remain -= cost[(i+j)%gas.length];
                if (remain<0)
                    break;
                remain += gas[(i+j+1)%gas.length];
            }
            if (remain >= 0)
                return i;
        }
        return -1;
    }
}
