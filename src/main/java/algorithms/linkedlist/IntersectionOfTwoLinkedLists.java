package algorithms.linkedlist;

import algorithms.ListNode;

/**
 * 160. Intersection of Two Linked Lists
 * Time: O(n)
 * Space: O(1)
 *
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        ListNode iteratorA = headA;
        ListNode iteratorB = headB;
        while (iteratorA != null || iteratorB != null) {
            if (iteratorA != null) {
                aLength++;
                iteratorA = iteratorA.next;
            }
            if (iteratorB != null) {
                bLength++;
                iteratorB = iteratorB.next;
            }
        }
        if (aLength > bLength) {
            while (aLength != bLength) {
                headA = headA.next;
                aLength--;
            }
        } else if (bLength > aLength) {
            while (aLength != bLength) {
                headB = headB.next;
                bLength--;
            }
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headB;
    }
}
