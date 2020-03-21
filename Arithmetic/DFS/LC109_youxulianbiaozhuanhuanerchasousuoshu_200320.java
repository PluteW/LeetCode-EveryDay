package LeetCode.Arithmetic.DFS;

import java.util.Deque;
import java.util.LinkedList;

public class LC109_youxulianbiaozhuanhuanerchasousuoshu_200320 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode sortedListToBST1(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(head.val);
        deque.offerFirst(root);
        ListNode listnode = head.next;
        while (!deque.isEmpty() && listnode != null){
            TreeNode node = deque.poll();
            node.left = new TreeNode(listnode.val);
            deque.addFirst(node.left);
            listnode = listnode.next;
            if (listnode != null){
                node.right = new TreeNode(listnode.val);
                deque.addFirst(node.right);
            }
            listnode = listnode.next;
        }
        return root;
    }


    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode mid = this.findMiddleElement(head);
        TreeNode node = new TreeNode(mid.val);
        if (head == mid) {
            return node;
        }
        node.left = this.sortedListToBST(head);
        node.right = this.sortedListToBST(mid.next);
        return node;
    }
    private ListNode findMiddleElement(ListNode head) {
        ListNode prevPtr = null;
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            prevPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (prevPtr != null) {
            prevPtr.next = null;
        }
        return slowPtr;
    }
}
