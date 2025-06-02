package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 92. Reverse Linked List II
 * Time: O(n)
 * Space: O(1)
 *
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode result = head;
        ListNode iterator = head;
        ListNode previousToLeft = null;
        ListNode nextToRight = null;
        int currentPosition = 0;
        while (iterator != null && currentPosition != left) {
            previousToLeft = iterator;
            iterator = iterator.next;
            currentPosition++;
        }
        ListNode tail = null;
        ListNode previous = null;
        while (iterator != null && currentPosition != right) {
            if (previous == null) {
                previous = new ListNode(iterator.val);
                tail = previous;
            } else {
                previous = new ListNode(iterator.val, previous);
            }
            iterator = iterator.next;
            currentPosition++;
        }
        if (iterator != null) {
            nextToRight = iterator.next;
            previous = new ListNode(iterator.val, previous);
        }
        if (previousToLeft == null) {
            result = previous;
        } else {
            previousToLeft.next = previous;
        }
        if (tail != null) {
            tail.next = nextToRight;
        }
        return result;
    }
}
