package LeetCode._PunchTheClock;

public class LC021_hebinglinggeyouxuliebiao_200501 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h1 = l1;
        ListNode h2 = l2;
        ListNode head;
        if (h1 == null)
            return l2;
        if (h2 == null)
            return l1;
        if (h1.val < h2.val) {
            head = h1;
            h1 = head.next;
        }else {
            head = h2;
            h2 = head.next;
        }
        ListNode temp = head;
        while (h1 != null || h2 != null){
            if (h2 ==null || h1 != null && h1.val < h2.val){
                temp.next = h1;
                temp = temp.next;
                h1 = temp.next;
            }else {
                temp.next = h2;
                temp = temp.next;
                h2 = temp.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
