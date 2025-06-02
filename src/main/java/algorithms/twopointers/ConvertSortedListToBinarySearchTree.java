package algorithms.twopointers;

import algorithms.ListNode;
import algorithms.TreeNode;

/**
 * 109. Convert Sorted List to Binary Search Tree
 * 
 */
public class ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        return sortedListToBST(head, null);
    }

    private TreeNode sortedListToBST(ListNode head, ListNode boundNode) {
        if (head == null || head == boundNode) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null && fast != boundNode && fast.next != boundNode) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast == slow) {
            return new TreeNode(slow.val);
        }
        return new TreeNode(slow.val, sortedListToBST(head, slow), sortedListToBST(slow.next, boundNode));
    }

}
