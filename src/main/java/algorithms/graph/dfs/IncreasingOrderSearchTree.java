package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 897. Increasing Order Search Tree
 * Time: O(n)
 * Space: O(n)
 *
 */
public class IncreasingOrderSearchTree {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] nodes = new TreeNode[2];
        rearrange(root, nodes);
        return nodes[0];
    }

    private void rearrange(TreeNode root, TreeNode[] nodes) {
        if (root.left == null && root.right == null) {
            fillNodes(root, nodes);
        } else if (root.left != null && root.right == null) {
            rearrange(root.left, nodes);
            root.left = null;
            fillNodes(root, nodes);
        } else if (root.left == null) {
            TreeNode next = root.right;
            root.right = null;
            fillNodes(root, nodes);
            rearrange(next, nodes);
        } else {
            rearrange(root.left, nodes);
            TreeNode next = root.right;
            root.left = null;
            root.right = null;
            fillNodes(root, nodes);
            rearrange(next, nodes);
        }
    }

    private void fillNodes(TreeNode root, TreeNode[] nodes) {
        if (nodes[0] == null) {
            nodes[0] = root;
        } else if (nodes[1] == null) {
            nodes[0].right = root;
            nodes[1] = root;
        } else {
            nodes[1].right = root;
            nodes[1] = root;
        }
    }
}
