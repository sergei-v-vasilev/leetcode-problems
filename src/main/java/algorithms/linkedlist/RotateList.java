package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 61. Rotate List
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int size = 0;
        ListNode iterator = head;
        while (iterator != null) {
            size++;
            iterator = iterator.next;
        }
        k = k < size ? k : k - size * (k / size);
        if (k == 0) {
            return head;
        }
        int count = 0;
        iterator = head;
        while (count < size - k - 1) {
            iterator = iterator.next;
            count++;
        }
        ListNode newHead = iterator.next;
        iterator.next = null;
        iterator = newHead;
        while (iterator.next != null) {
            iterator = iterator.next;
        }
        iterator.next = head;
        return newHead;
    }
}
