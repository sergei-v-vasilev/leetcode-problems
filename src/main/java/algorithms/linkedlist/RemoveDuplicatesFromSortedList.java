package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 83. Remove Duplicates from Sorted List
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode iterator = head.next;
        while (iterator != null && head.val == iterator.val) {
            iterator = iterator.next;
        }
        head.next = deleteDuplicates(iterator);
        return head;
    }
}
