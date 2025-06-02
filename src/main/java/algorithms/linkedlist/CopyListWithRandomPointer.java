package algorithms.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 138. Copy List with Random Pointer
 * Time: O(n)
 * Space: O(n)
 *
 */
public class CopyListWithRandomPointer {
    private static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        Node iterator = head;
        Node copyHead = null;
        Node copyIterator = null;
        while (iterator != null) {
            if (copyHead == null) {
                copyHead = new Node(iterator.val);
                copyIterator = copyHead;
            } else {
                copyIterator.next = new Node(iterator.val);
                copyIterator = copyIterator.next;
            }
            nodeMap.put(iterator, copyIterator);
            iterator = iterator.next;
        }
        iterator = head;
        copyIterator = copyHead;
        while (iterator != null) {
            if (iterator.random != null) {
                copyIterator.random = nodeMap.get(iterator.random);
            }
            iterator = iterator.next;
            copyIterator = copyIterator.next;
        }
        return copyHead;
    }
}
