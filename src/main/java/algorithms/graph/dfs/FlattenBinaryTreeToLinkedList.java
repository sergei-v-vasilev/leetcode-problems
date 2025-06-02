package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 114. Flatten Binary Tree to Linked List
 * Time: O(|E|+|V|)
 * Space: O(|V|)
 *
 */
public class FlattenBinaryTreeToLinkedList {
    public void flatten(TreeNode root) {
        flattenNodes(root);
    }

    private TreeNode flattenNodes(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        } else if (root.right != null && root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode lastNode = flattenNodes(root.right);
            lastNode.right = temp;
            return flattenNodes(lastNode.right);
        } else if (root.right != null) {
            return flattenNodes(root.right);
        } else {
            root.right = root.left;
            root.left = null;
            return flattenNodes(root.right);
        }
    }
}
