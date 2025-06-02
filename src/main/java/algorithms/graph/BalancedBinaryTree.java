package algorithms.graph;

/**
 * 110. Balanced Binary Tree
 */
public class BalancedBinaryTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public boolean isBalanced(TreeNode root) {
        int height = dfs(root);
        return height != -1;
    }

    public int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = root.left != null ? dfs(root.left) : 0;
        int rightHeight = root.right != null ? dfs(root.right) : 0;
        if (leftHeight == -1 || rightHeight == -1) return -1;
        if (Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
