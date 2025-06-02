package algorithms.graph.dfs;

import java.util.LinkedList;
import java.util.List;

/**
 * 429. N-ary Tree Level Order Traversal
 *
 */
public class NaryTreeLevelOrderTraversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int size = 1;
        while (!queue.isEmpty()) {
            List<Integer> row = new LinkedList<>();
            while (size > 0) {
                Node node = queue.pollFirst();
                row.add(node.val);
                if (!node.children.isEmpty()) {
                    queue.addAll(node.children);
                }
                size--;
            }
            result.add(row);
            size = queue.size();
        }
        return result;
    }
}
