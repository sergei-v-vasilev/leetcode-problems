package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 144. Binary Tree Preorder Traversal
 * Time: O(|E|+|V|)
 * Space: O(|V|)
 *
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        return preorderTraversal(root, new ArrayList<>());
    }

    private List<Integer> preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.left != null) {
            result = preorderTraversal(root.left, result);
        }
        if (root.right != null) {
            result = preorderTraversal(root.right, result);
        }
        return result;
    }
}
