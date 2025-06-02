package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 112. Path Sum
 * 20.02
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.val == targetSum && root.left == null && root.right == null) {
            return true;
        } else if (root.left == null && root.right == null) {
            return false;
        } else {
            if (root.left != null && hasPathSum(root.left, targetSum - root.val)) {
                return true;
            }
            if (root.right != null && hasPathSum(root.right, targetSum - root.val)) {
                return true;
            }
            return false;
        }
    }
}
