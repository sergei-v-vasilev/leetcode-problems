package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 700. Search in a Binary Search Tree
 * Time - O(n)
 * Space - O(n)
 *
 */
public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else if (root.val == val) {
            return root;
        } else if (root.val > val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
