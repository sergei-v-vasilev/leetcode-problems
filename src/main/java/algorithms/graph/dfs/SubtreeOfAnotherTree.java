package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 572. Subtree of Another Tree
 * Time: O(n * m), m - is the number of vertices in a subRoot
 * Space: O(n)
 * 
 */
public class SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (equals(root, subRoot)) return true;
        else if (root != null) return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        else return false;
    }

    private boolean equals(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left != null && right == null) return false;
        if (left == null && right != null) return false;
        if (left.val != right.val) return false;
        return equals(left.left, right.left) && equals(left.right, right.right);
    }
}
