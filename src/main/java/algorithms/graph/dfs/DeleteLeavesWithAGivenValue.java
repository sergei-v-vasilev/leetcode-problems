package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 1325. Delete Leaves With a Given Value
 * Time: O(|V|+|E|)
 * Space: O(|V|)
 * <p>
 * DFS
 */
public class DeleteLeavesWithAGivenValue {

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        return check(root, target);
    }

    private TreeNode check(TreeNode node, int target) {
        if (node.left == null && node.right == null && node.val == target) {
            return null;
        }
        if (node.val == target) {
            if (node.left != null) {
                node.left = check(node.left, target);
            }
            if (node.right != null) {
                node.right = check(node.right, target);
            }
            return node.left == null && node.right == null ? null : node;
        } else {
            if (node.left != null) {
                node.left = check(node.left, target);
            }
            if (node.right != null) {
                node.right = check(node.right, target);
            }
            return node;
        }
    }
}
