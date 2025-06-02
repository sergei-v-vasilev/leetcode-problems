package algorithms.divideconquer;


import algorithms.ListNode;

/**
 * 23. Merge k Sorted Lists
 * Time: O(n * log(k))
 * Space: O(n)
 * 
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeLists(ListNode[] lists, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            ListNode first = mergeLists(lists, start, mid);
            ListNode second = mergeLists(lists, mid + 1, end);
            return merge(first, second);
        }
        if (start >= 0 && start < lists.length) {
            return lists[start];
        } else {
            return null;
        }
    }

    private ListNode merge(ListNode l, ListNode r) {
        ListNode head = null;
        ListNode iterator = null;
        while (l != null && r != null) {
            if (head == null) {
                if (l.val < r.val) {
                    head = new ListNode(l.val);
                    l = l.next;
                } else {
                    head = new ListNode(r.val);
                    r = r.next;
                }
                iterator = head;
            } else {
                if (l.val < r.val) {
                    iterator.next = new ListNode(l.val);
                    l = l.next;
                } else {
                    iterator.next = new ListNode(r.val);
                    r = r.next;
                }
                iterator = iterator.next;
            }
        }
        while (l != null) {
            if (head == null) {
                head = new ListNode(l.val);
                l = l.next;
                iterator = head;
            } else {
                iterator.next = new ListNode(l.val);
                l = l.next;
                iterator = iterator.next;
            }
        }
        while (r != null) {
            if (head == null) {
                head = new ListNode(r.val);
                r = r.next;
                iterator = head;
            } else {
                iterator.next = new ListNode(r.val);
                r = r.next;
                iterator = iterator.next;
            }
        }
        return head;
    }
}
