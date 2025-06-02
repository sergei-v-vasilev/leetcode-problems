package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 86. Partition List
 * Time: O(n)
 * Space: O(1)
 *
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode pointer = head;
        ListNode initialSmallerNode = null;
        ListNode previousSmallerNode = null;
        ListNode initialBiggerNode = null;
        ListNode previousBiggerNode = null;
        while (pointer != null) {
            if (pointer.val < x) {
                if (previousSmallerNode != null) {
                    previousSmallerNode.next = pointer;
                } else {
                    initialSmallerNode = pointer;
                }
                previousSmallerNode = pointer;
            } else {
                if (previousBiggerNode != null) {
                    previousBiggerNode.next = pointer;
                } else {
                    initialBiggerNode = pointer;
                }
                previousBiggerNode = pointer;
            }
            pointer = pointer.next;
        }
        if (previousSmallerNode != null) {
            previousSmallerNode.next = initialBiggerNode;
        }
        if (previousBiggerNode != null) {
            previousBiggerNode.next = null;
        }
        return initialSmallerNode != null ? initialSmallerNode : initialBiggerNode;
    }
}
