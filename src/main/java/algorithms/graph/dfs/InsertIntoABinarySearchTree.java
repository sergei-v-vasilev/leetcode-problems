package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 701. Insert into a Binary Search Tree
 * Time - O(n)
 * Space - O(n)
 *
 */
public class InsertIntoABinarySearchTree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        insertValue(root, val);
        return root;
    }

    private void insertValue(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) {
                root.right = new TreeNode(val);
            } else {
                insertValue(root.right, val);
            }
        } else {
            if (root.left == null) {
                root.left = new TreeNode(val);
            } else {
                insertValue(root.left, val);
            }
        }
    }
}
