package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 234. Palindrome Linked List
 * Time - O(n)
 * Space - O(1)
 * 
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int length = 0;
        ListNode iterator = head;
        while (iterator != null) {
            length++;
            iterator = iterator.next;
        }
        int position = length % 2 == 0 ? length / 2 : length / 2 + 1;
        iterator = head;
        length = 0;
        ListNode previousNode = null;
        while (length < position) {
            length++;
            previousNode = iterator;
            iterator = iterator.next;
        }
        //reverse second part of list
        ListNode endOfTheMiddle = previousNode;
        previousNode = null;
        ListNode next;
        while (iterator != null) {
            next = iterator.next;
            iterator.next = previousNode;
            previousNode = iterator;
            iterator = next;
        }
        endOfTheMiddle.next = previousNode;
        ListNode nextNode = previousNode;
        iterator = head;
        while (nextNode != null) {
            if (iterator.val != nextNode.val) {
                return false;
            }
            iterator = iterator.next;
            nextNode = nextNode.next;
        }
        return true;
    }
}
