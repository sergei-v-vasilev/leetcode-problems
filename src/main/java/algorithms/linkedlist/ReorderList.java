package algorithms.linkedlist;

import algorithms.ListNode;

import java.util.LinkedList;

/**
 * 143. Reorder List
 * Time: O(n)
 * Space: O(n)
 *
 */
public class ReorderList {

    public void reorderList(ListNode head) {
        LinkedList<ListNode> dequeue = new LinkedList<>();
        ListNode iterator = head.next;
        while (iterator != null) {
            dequeue.addLast(iterator);
            iterator = iterator.next;
        }
        iterator = head;
        while (!dequeue.isEmpty()) {
            iterator.next = dequeue.pollLast();
            if (!dequeue.isEmpty()) {
                iterator.next.next = dequeue.pollFirst();
                iterator = iterator.next.next;
            } else {
                iterator = iterator.next;
            }
        }
        iterator.next = null;
    }

}
