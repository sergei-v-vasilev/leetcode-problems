package algorithms.sorting;

import algorithms.ListNode;

/**
 * 148. Sort List
 * Time: O(n * log (n))
 * Space: O(n)
 * 
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (head.next == slow && slow.next == null) {
            if (head.val < slow.val) {
                return head;
            } else {
                head.next = null;
                slow.next = head;
                return slow;
            }
        }
        ListNode tail = slow.next;
        slow.next = null;
        return merge(sortList(head), sortList(tail));
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode head = null;
        ListNode tail = null;
        while (left != null && right != null) {
            if (left.val < right.val) {
                if (head == null) {
                    head = left;
                    tail = head;
                } else {
                    tail.next = left;
                    tail = tail.next;
                }
                left = left.next;
            } else {
                if (head == null) {
                    head = right;
                    tail = head;
                } else {
                    tail.next = right;
                    tail = tail.next;
                }
                right = right.next;
            }
        }
        while (left != null) {
            if (head == null) {
                head = left;
                tail = head;
            } else {
                tail.next = left;
                tail = tail.next;
            }
            left = left.next;
        }
        while (right != null) {
            if (head == null) {
                head = right;
                tail = head;
            } else {
                tail.next = right;
                tail = tail.next;
            }
            right = right.next;
        }
        return head;
    }
}
