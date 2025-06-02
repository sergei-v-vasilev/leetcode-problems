package algorithms.graph;

import algorithms.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {

    /**
     * Time: O(n)
     * Space: O(n)
     *
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        LinkedList<TreeNode> stack = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        TreeNode current;
        stack.addLast(root);
        while (!stack.isEmpty()) {
            current = stack.getLast();
            if (current.left != null && !visited.contains(current.left)) {
                stack.addLast(current.left);
                continue;
            }
            if (current.right != null && !visited.contains(current.right)) {
                stack.addLast(current.right);
                continue;
            }
            current = stack.pollLast();
            visited.add(current);
            result.add(current.val);
        }
        return result;
    }


    /**
     * Time: O(n)
     * Space: O(n)
     *
     */
    public List<Integer> postorderTraversalRecursion(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) return result;
        postorderTraversal(root, result);
        return result;
    }

    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root.left != null) postorderTraversal(root.left, result);
        if (root.right != null) postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
