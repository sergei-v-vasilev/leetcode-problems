package algorithms.graph;

import algorithms.TreeNode;

import java.util.LinkedList;

/**
 * 173. Binary Search Tree Iterator
 *
 */
public class BSTIterator {

    private LinkedList<TreeNode> inOrderList;

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public BSTIterator(TreeNode root) {
        inOrderList = new LinkedList<>();
        inorder(root);
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorder(root.left);
        }
        inOrderList.addLast(root);
        if (root.right != null) {
            inorder(root.right);
        }
    }

    /**
     * Time: O(1)
     */
    public int next() {
        return inOrderList.pollFirst().val;
    }

    /**
     * Time: O(1)
     */
    public boolean hasNext() {
        return !inOrderList.isEmpty();
    }
}
