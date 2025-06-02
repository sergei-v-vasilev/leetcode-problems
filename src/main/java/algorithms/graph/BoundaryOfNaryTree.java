package algorithms.graph;

import java.util.LinkedList;
import java.util.List;

public class BoundaryOfNaryTree {

    private static class Node {
        int val;
        List<Node> children;

        public Node(int val) {
            this.val = val;
            this.children = new LinkedList<>();
        }
    }

    /**
     * 4
     * /  \
     * 5    7
     * /
     * 3
     * 3 5 4 7
     */
    public List<Integer> boundaryOfTree(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (size == 1) {
                Node node = queue.poll();
                result.addFirst(node.val);
                queue.addAll(node.children);
            } else {
                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    queue.addAll(node.children);
                    if (i == 0) {
                        result.addFirst(node.val);
                    } else if (i == size - 1) {
                        result.addLast(node.val);
                    }
                }
            }
        }
        return result;
    }
}
