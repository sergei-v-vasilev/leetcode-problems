package algorithms.heap;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * 716. Max Stack
 */
public class MaxStack {

    private class Node {
        int value;
        Node next;
        Node previous;

        public Node(int value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    private Node last;
    private final TreeMap<Integer, LinkedList<Node>> tree;

    public MaxStack() {
        tree = new TreeMap<>();
    }

    public void push(int x) {
        if (last == null) {
            last = new Node(x, null, null);
        } else {
            last.next = new Node(x, last, null);
            last = last.next;
        }
        LinkedList<Node> stack = tree.getOrDefault(x, new LinkedList<>());
        stack.add(last);
        tree.put(x, stack);
    }

    public int pop() {
        if (last == null) {
            return -1;
        }
        int value = last.value;
        last = last.previous;
        removeLastNodeFromTree(value);
        return value;
    }

    public int top() {
        if (last == null) {
            return -1;
        }
        return last.value;
    }

    public int peekMax() {
        if (tree.isEmpty()) {
            return -1;
        }
        return tree.lastEntry().getValue().getLast().value;
    }

    public int popMax() {
        if (tree.isEmpty()) {
            return -1;
        }
        Node biggest = tree.lastEntry().getValue().getLast();
        if (biggest == last) {
            pop();
        } else {
            Node previous = biggest.previous;
            Node next = biggest.next;
            if (previous != null) {
                previous.next = next;
            }
            if (next != null) {
                next.previous = previous;
            }
            removeLastNodeFromTree(biggest.value);
        }
        return biggest.value;
    }

    private void removeLastNodeFromTree(int value) {
        LinkedList<Node> stack = tree.getOrDefault(value, new LinkedList<>());
        stack.removeLast();
        if (stack.isEmpty()) {
            tree.remove(value);
        } else {
            tree.put(value, stack);
        }
    }
}