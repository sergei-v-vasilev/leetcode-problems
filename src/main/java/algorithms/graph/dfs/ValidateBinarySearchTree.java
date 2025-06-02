package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 98. Validate Binary Search Tree
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class ValidateBinarySearchTree {
    private class Triplet {
        boolean isBST;
        int min;
        int max;

        Triplet(boolean isBst, int min, int max) {
            this.isBST = isBst;
            this.min = min;
            this.max = max;
        }
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return check(root).isBST;
    }

    private Triplet check(TreeNode root) {
        int min = root.val;
        int max = root.val;
        boolean isBst = true;
        if (root.left != null) {
            Triplet leftTriplet = check(root.left);
            isBst = leftTriplet.isBST && leftTriplet.max < root.val;
            min = leftTriplet.min;
        }
        if (root.right != null) {
            Triplet rightTriplet = check(root.right);
            isBst = isBst && rightTriplet.isBST && rightTriplet.min > root.val;
            max = rightTriplet.max;
        }
        return new Triplet(isBst, min, max);
    }
}
