package algorithms.math;

import algorithms.ListNode;

/**
 * 2. Add Two Numbers
 * Time: O(n)
 * Space: O(1)
 *
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode result = null;
        int mod = 0;
        int value;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                value = l1.val + l2.val + mod;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                value = l1.val + mod;
                l1 = l1.next;
            } else {
                value = l2.val + mod;
                l2 = l2.next;
            }
            if (result == null) {
                result = new ListNode(value % 10);
                head = result;
                mod = value / 10;
            } else {
                result.next = new ListNode(value % 10);
                mod = value / 10;
                result = result.next;
            }
        }
        if (mod > 0) {
            result.next = new ListNode(mod);
        }
        return head;
    }
}
