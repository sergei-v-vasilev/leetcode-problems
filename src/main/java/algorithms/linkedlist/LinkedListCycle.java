package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 141. Linked List Cycle
 * Time - O(n)
 * Space - O(1)
 * 
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode faster = head;
        do {
            slow = slow.next;
            faster = faster.next.next;
        } while (slow != faster && faster != null && faster.next != null);
        return faster != null && faster.next != null;
    }
}
