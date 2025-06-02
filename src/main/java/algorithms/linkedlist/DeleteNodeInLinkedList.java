package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 237. Delete Node in a Linked List
 * Time: O(n)
 * Space: O(1)
 *
 */
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        while (node.next.next != null) {
            node = node.next;
            node.val = node.next.val;
        }
        node.next = null;
    }
}
