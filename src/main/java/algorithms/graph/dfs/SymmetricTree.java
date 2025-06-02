package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 101. Symmetric Tree
 * Time - O(n)
 * Space - O(1)
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || root != null && isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);

    }
}
