package LeetCode.汇总;

public class LC378_juzhendiKxiaodeyuansu_200310 {
    public static void main(String[] args) {

    }
    /**
     * @Description： 二分法 + 计数
     * @Params:     int[][] matrix  数组数据    int k 需要返回的第 k 个数字
     * @return:     int right  最后返回的结果
     * @author: Mr.Wang
     * @create: 23:02
    */
    public int solution(){
        int[][] matrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        int k = 8;
        int row = matrix.length;
        int col = matrix[0].length;
        int left = matrix[0][0];
        int right = matrix[row-1][col-1];

        while (left <right){
            int mid = left+(right-left)/2;
            int count = search(matrix,mid,row,col);
            if (count < k)
                left = mid+1;
            else
                right = mid;
        }
        return right;
    }
    public int search(int[][] matrix,int mid,int row,int col){
        int i = row-1;
        int j = 0;
        int count = 0;
        while (i>=0 && j<col){
            if (matrix[i][j] <= mid){
                count += i+1;           //  这里补上了前面几行的空缺
                j++;
            }else
                i--;
        }
        return count;
    }
}
