package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 450. Delete Node in a BST
 * Time: O(log(n))
 * Space: O(log(n))
 *
 */
public class DeleteNodeInBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode rootOfKey = findRootOfTarget(root, key);
        if (rootOfKey == null) {
            if (root == null || root.val != key) {
                return root;
            }
            Integer min = findMin(root.right);
            if (min != null) {
                return new TreeNode(min, root.left, deleteNode(root.right, min));
            }
            Integer max = findMax(root.left);
            if (max != null) {
                return new TreeNode(max, deleteNode(root.left, max), root.right);
            }
            return null;
        } else {
            if (rootOfKey.left != null && root.left.val == key) {
                rootOfKey.left = deleteNode(rootOfKey.left, key);
            } else {
                rootOfKey.right = deleteNode(rootOfKey.right, key);
            }
            return root;
        }
    }

    private TreeNode findRootOfTarget(TreeNode root, int key) {
        if (root == null || key == root.val) {
            return null;
        }
        if (root.val < key) {
            if (root.right != null && root.right.val == key) {
                return root;
            } else {
                return findRootOfTarget(root.right, key);
            }
        } else {
            if (root.left != null && root.left.val == key) {
                return root;
            } else {
                return findRootOfTarget(root.left, key);
            }
        }
    }

    private Integer findMax(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root.val;
        }
        return findMax(root.right);
    }

    private Integer findMin(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.val;
        }
        return findMin(root.left);
    }
}
