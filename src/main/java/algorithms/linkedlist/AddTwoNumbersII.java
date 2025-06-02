package algorithms.linkedlist;

import algorithms.ListNode;

import java.util.LinkedList;

/**
 * 445. Add Two Numbers II
 * Time: O(n * n)
 * Space: O(n)
 * 
 */
public class AddTwoNumbersII {

    public ListNode addTwoNumbers(ListNode l, ListNode r) {
        int sizeL = 0;
        int sizeR = 0;
        ListNode left = l;
        ListNode right = r;
        while (left != null || right != null) {
            if (left != null) {
                sizeL++;
                left = left.next;
            }
            if (right != null) {
                sizeR++;
                right = right.next;
            }
        }
        ListNode bigger = sizeL > sizeR ? l : r;
        ListNode smaller = sizeL > sizeR ? r : l;
        LinkedList<ListNode> number = new LinkedList<>();
        int diff = Math.abs(sizeL - sizeR);
        ListNode currentNode = null;
        while (diff > 0) {
            if (currentNode != null) {
                currentNode.next = new ListNode(bigger.val);
                currentNode = currentNode.next;
            } else {
                currentNode = new ListNode(bigger.val);
            }
            number.addFirst(currentNode);
            bigger = bigger.next;
            diff--;
        }
        int value;
        while (bigger != null) {
            value = bigger.val + smaller.val;
            if (currentNode != null) {
                currentNode.next = new ListNode(value % 10);
                currentNode = currentNode.next;
            } else {
                currentNode = new ListNode(value % 10);
            }
            if (value > 9) {
                for (ListNode digit : number) {
                    if (value < 10) break;
                    value = value / 10 + digit.val;
                    digit.val = value % 10;
                }
                number.addFirst(currentNode);
                if (value > 9) {
                    ListNode head = new ListNode(value / 10);
                    head.next = number.getLast();
                    number.addLast(head);
                }
            } else {
                number.addFirst(currentNode);
            }
            bigger = bigger.next;
            smaller = smaller.next;
        }
        return number.getLast();
    }
}
