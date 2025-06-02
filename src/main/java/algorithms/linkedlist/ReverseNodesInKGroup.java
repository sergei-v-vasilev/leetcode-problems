package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 25. Reverse Nodes in k-Group
 * Time: O(n)
 * Space: O(1)
 *
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode result = null;
        ListNode[] reverseResult;
        ListNode previous = null;
        while (head != null) {
            reverseResult = localReverseKGroup(head, k);
            head = reverseResult[1];
            if (result == null) {
                result = reverseResult[0];
            }
            if (previous != null) {
                previous.next = reverseResult[0];
            }
            previous = reverseResult[2];
        }
        return result;
    }

    private ListNode[] localReverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode previous = null;
        ListNode next;
        ListNode tail = head;
        while (count < k && head != null) {
            next = head.next;
            head.next = previous;
            previous = head;
            head = next;
            count++;
        }
        if (count < k) {
            head = previous;
            previous = null;
            while (head != null) {
                next = head.next;
                head.next = previous;
                previous = head;
                head = next;
            }
            return new ListNode[]{previous, null, null};
        } else {
            return new ListNode[]{previous, head, tail};
        }
    }
}
