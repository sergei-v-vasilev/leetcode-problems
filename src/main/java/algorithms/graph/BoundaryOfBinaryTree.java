package algorithms.graph;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 545. Boundary of Binary Tree
 */
public class BoundaryOfBinaryTree {


    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        result.add(root.val);
        if (root.left == null && root.right == null) {
            return result;
        }
        dfsLeft(root.left, result);
        dfsLeafs(root, result);
        dfsRight(root.right, result);
        return result;
    }

    private void dfsLeft(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            return;
        }
        result.add(root.val);
        if (root.left != null) {
            dfsLeft(root.left, result);
        } else if (root.right != null) {
            dfsLeft(root.right, result);
        }
    }

    private void dfsLeafs(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left != null) {
            dfsLeafs(root.left, result);
        }
        if (root.right != null) {
            dfsLeafs(root.right, result);
        }
        if (root.left == null && root.right == null) {
            result.add(root.val);
        }
    }

    private void dfsRight(TreeNode root, List<Integer> result) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            return;
        }
        if (root.right != null) {
            dfsRight(root.right, result);
        } else if (root.left != null) {
            dfsRight(root.left, result);
        }
        result.add(root.val);
    }

}
