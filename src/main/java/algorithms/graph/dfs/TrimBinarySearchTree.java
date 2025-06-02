package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 669. Trim a Binary Search Tree
 * Time: O(n)
 * Space: O(n)
 *
 */
public class TrimBinarySearchTree {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        } else if (root.val < low) {
            return trimBST(root.right, low, high);
        } else if (root.val > high) {
            return trimBST(root.left, low, high);
        } else {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }

}
