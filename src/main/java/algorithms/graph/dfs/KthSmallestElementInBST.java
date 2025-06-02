package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 230. Kth Smallest Element in a BST
 * Time: O(n)
 * Space: O(1)
 *
 */
public class KthSmallestElementInBST {

    private int count = 0;
    private TreeNode countNode = null;

    public int kthSmallest(TreeNode root, int k) {
        calculateCount(root, k);
        return countNode != null ? countNode.val : 0;
    }

    private void calculateCount(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            count++;
            countNode = root;
            return;
        }
        if (root.left != null) {
            calculateCount(root.left, k);
            if (k == count) {
                return;
            }
        }
        count++;
        countNode = root;
        if (k == count) {
            return;
        }
        if (root.right != null) {
            calculateCount(root.right, k);
        }
    }
}
