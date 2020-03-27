package LeetCode.汇总;

public class LC011_zuidarongqi_200110 {

    public static void main(String [] args){

        int area = solution();
        System.out.println(area);

    }

    /**
     *      暴力解法
     *
     * **/

    public static int solution(){

        int[] a = {1,8,6,2,5,4,8,3,7};

        int i = 0;
        int j = 0;

        int area = 0;

        while( i < a.length ) {

            int width = j - i;
            int height = Math.min(a[i] , a[j]);

            while ( j < a.length ) {
                width = j - i;
                height = Math.min(a[i] , a[j]);
                if ( width * height > area ) area = width * height;
                j++;
            }
            i++;
            j = i;
        }
        return area;
    }
}
