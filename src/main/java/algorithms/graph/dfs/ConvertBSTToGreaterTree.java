package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 538. Convert BST to Greater Tree
 * Time: O(n)
 * Space: O(n)
 *
 */
public class ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        sum(root, 0);
        return root;
    }

    private int sum(TreeNode root, int value) {
        if (root == null) return value;
        int greaterSum = sum(root.right, value);
        root.val = root.val + greaterSum;
        return sum(root.left, root.val);
    }
}
