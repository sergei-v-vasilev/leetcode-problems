package algorithms.linkedlist;


import algorithms.ListNode;

import java.util.*;

/**
 * 147. Insertion Sort List
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        Map<Integer, Set<ListNode>> map = new HashMap<>();
        List<Integer> list = new LinkedList<>();
        ListNode iterator = head;
        while (iterator != null) {
            Set<ListNode> set = map.getOrDefault(iterator.val, new HashSet<>());
            set.add(iterator);
            map.put(iterator.val, set);
            list.add(iterator.val);
            iterator = iterator.next;
        }
        Collections.sort(list);
        ListNode resultHead = null;
        ListNode previous = null;
        for (int value : list) {
            Set<ListNode> set = map.get(value);
            for (ListNode node : set) {
                if (previous == null) {
                    resultHead = node;
                } else {
                    previous.next = node;
                }
                previous = node;
            }
        }
        if (previous != null) previous.next = null;
        return resultHead;
    }
}
