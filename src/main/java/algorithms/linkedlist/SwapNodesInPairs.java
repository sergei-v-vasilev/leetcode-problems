package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 24. Swap Nodes in Pairs
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode tail = head.next.next;
        next.next = head;
        head.next = swapPairs(tail);
        return next;
    }

}
