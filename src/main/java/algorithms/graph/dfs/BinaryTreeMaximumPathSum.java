package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 124. Binary Tree Maximum Path Sum
 * Time: O(n)
 * Space: O(n)
 *
 */
public class BinaryTreeMaximumPathSum {

    private int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        longestPath(root);
        return max;
    }

    private int longestPath(TreeNode root) {
        max = Math.max(max, root.val);
        if (root.left == null && root.right == null) {
            return root.val;
        } else if (root.left != null && root.right != null) {
            int left = longestPath(root.left);
            int right = longestPath(root.right);
            max = Math.max(max, left + right + root.val);
            max = Math.max(max, right + root.val);
            max = Math.max(max, left + root.val);
            return Math.max(root.val, Math.max(root.val + left, root.val + right));
        } else if (root.left != null) {
            int left = longestPath(root.left);
            max = Math.max(max, left + root.val);
            return Math.max(root.val, root.val + left);
        } else {
            int right = longestPath(root.right);
            max = Math.max(max, right + root.val);
            return Math.max(root.val, root.val + right);
        }
    }
}
