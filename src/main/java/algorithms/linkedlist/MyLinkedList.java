package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 707. Design Linked List
 */
public class MyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || size <= index) {
            return -1;
        }
        ListNode iterator = head;
        for (int i = 0; i < index; i++) {
            if (iterator == null) {
                return -1;
            }
            iterator = iterator.next;
        }
        return iterator.val;
    }

    public void addAtHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
        } else {
            head = new ListNode(val, head);
        }
        size++;
    }

    public void addAtTail(int val) {
        if (tail == null) {
            tail = new ListNode(val);
            head = tail;
        } else {
            tail.next = new ListNode(val);
            tail = tail.next;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
        } else if (index >= size) {
            addAtTail(val);
        } else {
            ListNode iterator = head;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.next;
            }
            ListNode temp = iterator.next;
            iterator.next = new ListNode(val, temp);
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            head = head.next;
            size--;
        } else if (index == size - 1) {
            ListNode iterator = head;
            while (iterator.next != tail) {
                iterator = iterator.next;
            }
            iterator.next = null;
            tail = iterator;
            size--;
        } else if (index < size - 1) {
            ListNode iterator = head;
            for (int i = 0; i < index - 1; i++) {
                iterator = iterator.next;
            }
            iterator.next = iterator.next.next;
            size--;
        }
    }
}

