package LeetCode._PunchTheClock;

public class LC206_fanzhuanlianbiao_200302 {

    public static void main(String[] args) {

    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    /**
     * @Description： 迭代的思路，由于当前节点的下一个节点是可以直接进行访问的，而前一个节点不能直接访问，所以需要进行保存
     * @Params: ListNode，链表的起始节点，head
     * @return: 返回链表最后一个节点，由此链接向前面的节点
     * @author: Mr.Wang
     * @create: 22:29
    */
    public ListNode solution(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        ListNode next;
        while (current != null){
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * @Description： 递归思路，假设后面的已经完成了反转，我们当下应该做什么
     * @Params: ListNode 链表的头节点 head
     * @return: 链表的最后一个节点
     * @author: Mr.Wang
     * @create: 22:37
    */
    public ListNode solution2(ListNode head){
        if (head == null || head.next == head) {
            return head;
        }
        ListNode pre = solution2(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }

//    预定义数据结构，链节点
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
