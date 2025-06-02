package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 2095. Delete the Middle Node of a Linked List
 *
 */
public class DeleteTheMiddleNodeOfALinkedList {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slowest = head;
        ListNode faster = head;
        ListNode previous = head;
        while (faster.next != null) {
            previous = slowest;
            slowest = slowest.next;
            faster = faster.next;
            if (faster.next != null) {
                faster = faster.next;
            }
        }
        previous.next = slowest.next;
        return head;
    }
}
