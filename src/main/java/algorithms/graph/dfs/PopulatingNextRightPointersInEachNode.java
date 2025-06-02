package algorithms.graph.dfs;

/**
 * 116. Populating Next Right Pointers in Each Node
 * Time: O(n)
 * Space: O(1)
 *
 */
public class PopulatingNextRightPointersInEachNode {

    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        connect(root, null);
        return root;
    }

    private void connect(Node root, Node toConnectWith) {
        if (root == null) return;
        root.next = toConnectWith;
        if (root.left != null && root.right != null) {
            connect(root.left, root.right);
            connect(root.right, toConnectWith != null ? toConnectWith.left : null);
        }
    }
}
