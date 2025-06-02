package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 111. Minimum Depth of Binary Tree
 * Time: O(n)
 * Space: O(n)
 *
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepth(root, 0);
    }

    private int minDepth(TreeNode root, int numberOfNodes) {
        if (root.left == null && root.right == null) {
            return numberOfNodes + 1;
        } else if (root.left != null && root.right != null) {
            return Math.min(minDepth(root.left, numberOfNodes + 1), minDepth(root.right, numberOfNodes + 1));
        } else if (root.left != null) {
            return minDepth(root.left, numberOfNodes + 1);
        } else {
            return minDepth(root.right, numberOfNodes + 1);
        }
    }
}
