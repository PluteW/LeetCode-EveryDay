package LeetCode._test;

import java.util.Arrays;

public class QuickSort_200313 {

    public static void main(String[] args) {
        int a[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
        quickSort1(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * @Description： 快速排序 算法 1 （不是很好理解，而且吃栈较多）
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 22:12
    */
    public static void quickSort1(int a[]) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(int a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }
        i = low;
        j = hight;
        index = a[i]; // 用子表的第一个记录做基准
        while (i < j) { // 从表的两端交替向中间扫描
            while (i < j && a[j] >= index)
                j--;
            if (i < j)
                a[i++] = a[j];// 用比基准小的记录替换低位记录
            while (i < j && a[i] < index)
                i++;
            if (i < j) // 用比基准大的记录替换高位记录
                a[j--] = a[i];
        }
        a[i] = index;// 将基准数值替换回 a[i]
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序

    }


    /**
     * @Description： 快速排序  算法2  （理解更加容易，而且有注意要点）
     * @Params:
     * @return:
     * @author: Mr.Wang
     * @create: 22:13
    */
    public static void quickSort2(int[] arr,int low,int high) {
        int p,i,j,temp;
        if(low >= high) {
            return;
        }
        //p就是基准数,这里就是每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while(i < j) {
            //右边当发现小于p的值时停止循环
            while(arr[j] >= p && i < j) {
                j--;
            }
            //这里一定是右边开始，上下这两个循环不能调换（下面有解析，可以先想想）
            //左边当发现大于p的值时停止循环
            while(arr[i] <= p && i < j) {
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        arr[low] = arr[i];//这里的arr[i]一定是停小于p的，经过i、j交换后i处的值一定是小于p的(j先走)
        arr[i] = p;
        quickSort2(arr,low,j-1);  //对左边快排
        quickSort2(arr,j+1,high); //对右边快排
    }


}