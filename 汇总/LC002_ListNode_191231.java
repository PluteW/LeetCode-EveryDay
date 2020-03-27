package LeetCode.汇总;

import java.util.Iterator;
import java.util.LinkedList;

/*
题目：
* 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
* 并且它们的每个节点只能存储一位数字。
* 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
* 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
*
* */
public class LC002_ListNode_191231 {

    public static void main(String [] args ){


//      数据来源1
        LinkedList l1 = new LinkedList();
        l1.add(7);
        l1.add(5);
        l1.add(1);
//      数据来源2
        LinkedList l2 = new LinkedList();
        l2.add(5);
        l2.add(2);
        l2.add(9);
        System.out.println(l1);
        System.out.println(l2);
//      来俩迭代器
        Iterator iterator1 = l1.iterator();
        Iterator iterator2 = l2.iterator();
//      初始化存储结果的链表
        LinkedList result = new LinkedList();
//      临时变量们
        int sum1 = 0;
        int sum2 = 0;
        int i = 0;  //用于记录当前数字的倍率
//      将来源于1的数字进行复原
        while (iterator1.hasNext()){
            sum1 += (Math.pow(10,i)) * (int)iterator1.next();
            i++;
        }
//      临时变量还原，再次将来源2的数字还原
        i = 0;
        while (iterator2.hasNext()){
            sum2 += (Math.pow(10,i)) * (int)iterator2.next();
            i++;
        }
//      直接加和
        int sum_tem = sum1+sum2;
        int tem = 0;
        while (sum_tem>=1){
            tem = sum_tem%10;
            result.add(tem);
            sum_tem = sum_tem /10;
        }

        System.out.println(result);

    }
    

}
