package algorithms.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 432. All O`one Data Structure
 */
public class AllOne {

    private class Node {
        int count;
        Node next;
        Node previous;
        Set<String> set;

        Node(int count, Node next, Node previous) {
            this.next = next;
            this.previous = previous;
            this.count = count;
            this.set = new HashSet<>();
        }
    }

    private Node smallest;
    private Node largest;
    private Map<String, Node> map;

    public AllOne() {
        this.map = new HashMap<>();
    }

    public void inc(String key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            if (node.next != null && node.next.count > node.count + 1) {
                Node newNode = new Node(node.count + 1, node.next, node);
                node.next.previous = newNode;
                node.next = newNode;
                newNode.set.add(key);
                map.put(key, newNode);
            } else if (node.next != null && node.next.count == node.count + 1) {
                node.next.set.add(key);
                map.put(key, node.next);
            } else if (node.next == null) {
                Node newNode = new Node(node.count + 1, null, node);
                node.next = newNode;
                newNode.set.add(key);
                map.put(key, newNode);
                largest = newNode;
            }
            removeKeyFromNode(key, node);
        } else if (smallest == null) {
            smallest = new Node(1, null, null);
            largest = smallest;
            smallest.set.add(key);
            map.put(key, smallest);
        } else if (smallest.count > 1) {
            Node oldSmallest = smallest;
            smallest = new Node(1, smallest, null);
            oldSmallest.previous = smallest;
            smallest.set.add(key);
            map.put(key, smallest);
        } else if (smallest.count == 1) {
            smallest.set.add(key);
            map.put(key, smallest);
        }
    }

    public void dec(String key) {
        Node node = map.get(key);
        if (node.count == 1) {
            map.remove(key);
        } else if (node.previous != null && node.previous.count == node.count - 1) {
            node.previous.set.add(key);
            map.put(key, node.previous);
        } else if (node.previous != null && node.previous.count < node.count - 1) {
            Node newNode = new Node(node.count - 1, node, node.previous);
            node.previous.next = newNode;
            node.previous = newNode;
            newNode.set.add(key);
            map.put(key, newNode);
        } else if (node.previous == null) {
            Node newNode = new Node(node.count - 1, node, null);
            node.previous = newNode;
            smallest = newNode;
            newNode.set.add(key);
            map.put(key, newNode);
        }
        removeKeyFromNode(key, node);
    }

    public String getMaxKey() {
        if (largest == null) {
            return "";
        }
        return largest.set.iterator().next();
    }

    public String getMinKey() {
        if (smallest == null) {
            return "";
        }
        return smallest.set.iterator().next();
    }

    private Node removeKeyFromNode(String key, Node node) {
        Node prev = node.previous;
        Node next = node.next;
        node.set.remove(key);
        if (node.set.isEmpty()) {
            if (smallest == node) {
                smallest = next;
                if (smallest == null) {
                    largest = null;
                }
            }
            if (largest != null && largest == node) {
                largest = prev;
                if (largest == null) {
                    smallest = null;
                }
            }
            if (prev != null) {
                prev.next = next;
            }
            if (next != null) {
                next.previous = prev;
            }
            return prev;
        }
        return node;
    }
}
