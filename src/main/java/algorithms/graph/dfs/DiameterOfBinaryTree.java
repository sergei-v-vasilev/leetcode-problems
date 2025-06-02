package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 543. Diameter of Binary Tree
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class DiameterOfBinaryTree {

    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int leftPath = longestPath(root.left);
        int rightPath = longestPath(root.right);
        max = Math.max(max, leftPath + rightPath);
        return max;
    }

    public int longestPath(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int leftPath = longestPath(root.left);
        int rightPath = longestPath(root.right);
        max = Math.max(max, leftPath + rightPath);
        return Math.max(leftPath, rightPath) + 1;
    }
}
