package algorithms.graph;

/**
 * 117. Populating Next Right Pointers in Each Node II
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class PopulatingNextRightPointersInEachNodeII {

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
        if (root == null) return null;
        connect(root, null);
        return root;
    }


    private void connect(Node root, Node toConnectWith) {
        root.next = toConnectWith;
        if (root.left != null && root.right != null) {
            connectWith(root.right, toConnectWith);
            connect(root.left, root.right);
        } else if (root.left != null) {
            connectWith(root.left, toConnectWith);
        } else if (root.right != null) {
            connectWith(root.right, toConnectWith);
        }
    }

    private void connectWith(Node node, Node toConnectWith) {
        if (toConnectWith != null && toConnectWith.left != null) {
            connect(node, toConnectWith.left);
        } else if (toConnectWith != null && toConnectWith.right != null) {
            connect(node, toConnectWith.right);
        } else if (toConnectWith != null) {
            connectWith(node, toConnectWith.next);
        } else {
            connect(node, null);
        }
    }

}
