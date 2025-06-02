package algorithms.twopointers;

import algorithms.ListNode;

/**
 * 142. Linked List Cycle II
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head.next;
        ListNode faster = head.next.next;
        while (slow != faster && faster != null) {
            slow = slow.next;
            faster = faster.next != null ? faster.next.next : null;
        }
        if (faster == null) {
            return null;
        }
        slow = head;
        while (slow != faster) {
            slow = slow.next;
            faster = faster.next;
        }
        return slow;
    }
}
