package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 104. Maximum Depth of Binary Tree
 * Time: O(n)
 * Space: O(n)
 *
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
