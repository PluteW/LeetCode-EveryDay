package LeetCode.Arithmetic.Sort;

public class LC1616_bufenpaixu_200501 {
    public int[] subSort(int[] array) {
        if(array == null || array.length == 0) return new int[]{-1, -1};
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for(int i = 0; i < len; i++){
            if(array[i] < max){
                last = i;
            }else{
                max = array[i];
            }
            if(array[len - 1 - i] > min){
                first = len - 1 - i;
            }else{
                min = array[len - 1 - i];
            }
        }
        return new int[] {first, last};
    }
}
