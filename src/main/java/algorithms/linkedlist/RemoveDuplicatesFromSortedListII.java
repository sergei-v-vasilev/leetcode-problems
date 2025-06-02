package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 82. Remove Duplicates from Sorted List II
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode resultHead = getNextUniqueNode(head);
        ListNode iterator = resultHead;
        while (iterator != null) {
            iterator.next = getNextUniqueNode(iterator.next);
            iterator = iterator.next;
        }
        return resultHead;
    }

    private ListNode getNextUniqueNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode iterator = head.next;
        if (head.val != iterator.val) {
            return head;
        }
        while (head.val == iterator.val) {
            iterator = iterator.next;
            if (iterator == null) {
                return null;
            }
        }
        return getNextUniqueNode(iterator);
    }
}
