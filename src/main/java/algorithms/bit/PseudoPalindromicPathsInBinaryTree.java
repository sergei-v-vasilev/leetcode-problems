package algorithms.bit;

import algorithms.TreeNode;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 *
 */
public class PseudoPalindromicPathsInBinaryTree {

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int path) {
        path = path ^ (1 << root.val);
        int count;
        if (root.left != null && root.right != null) {
            count = dfs(root.left, path) + dfs(root.right, path);
        } else if (root.left != null) {
            count = dfs(root.left, path);
        } else if (root.right != null) {
            count = dfs(root.right, path);
        } else {
            if (check(path)) {
                return 1;
            } else {
                return 0;
            }
        }
        return count;
    }

    private boolean check(int path) {
        int count = 0;
        while (path != 0) {
            if ((path & 1) != 0) {
                count++;
            }
            if (count > 1) {
                return false;
            }
            path = path << 1;
        }
        return true;
    }

}
