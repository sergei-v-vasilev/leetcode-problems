package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * Time: O(|E|+|V|)
 * Space: O(|V|)
 */
public class BinaryTreeInorderTraversal {


    public List<Integer> inorderTraversal(TreeNode root) {
        return inorderTraversal(root, new ArrayList<>());
    }

    private List<Integer> inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        if (root.left != null) {
            result = inorderTraversal(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            result = inorderTraversal(root.right, result);
        }
        return result;
    }
}
