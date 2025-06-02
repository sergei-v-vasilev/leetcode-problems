package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 328. Odd Even Linked List
 * Time: O(n)
 * Space: O(1)
 *
 */
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
