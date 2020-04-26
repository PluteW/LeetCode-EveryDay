package LeetCode.汇总;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC023_hebingKgepaixuxulie_200426 {


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for (ListNode listNode : lists){
            if(listNode != null)
                queue.add(listNode);
        }
        ListNode ret = queue.poll();
        if(ret == null) return null;
        if (ret.next != null)
            queue.add(ret.next);
        ListNode temp = ret;
        ListNode top;
        while (!queue.isEmpty()){
            top = queue.poll();
            temp.next = top;
            if (top.next!=null){
                queue.add(top.next);
            }
            temp = temp.next;
        }
        return ret;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
