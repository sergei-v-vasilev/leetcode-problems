package algorithms.graph;


import algorithms.TreeNode;

/**
 * 99. Recover Binary Search Tree
 *
 */
public class RecoverBinarySearchTree {
    private TreeNode prev;
    private TreeNode first;
    private TreeNode mid;
    private TreeNode last;

    public void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (root.val < prev.val) {
            if (first != null) {
                last = root;
            } else {
                first = prev;
                mid = root;
            }
        }
        prev = root;
        inorder(root.right);
    }

    public void recoverTree(TreeNode root) {
        prev = new TreeNode(Integer.MIN_VALUE);
        first = mid = last = null;
        inorder(root);
        if (first != null && last != null) {
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        } else if (first != null && mid != null) {
            int temp = first.val;
            first.val = mid.val;
            mid.val = temp;
        }
    }
}
