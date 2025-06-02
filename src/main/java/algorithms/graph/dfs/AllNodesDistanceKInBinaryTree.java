package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 863. All Nodes Distance K in Binary Tree
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class AllNodesDistanceKInBinaryTree {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        LinkedList<TreeNode> path = findPathToTarget(root, target, new LinkedList<>());
        List<Integer> elements = new LinkedList<>();
        int distance = 0;
        TreeNode previous = null;
        TreeNode current;
        while (!path.isEmpty() && distance <= k) {
            current = path.pollLast();
            if (previous != null && current.left != null && current.left.val == previous.val) current.left = null;
            if (previous != null && current.right != null && current.right.val == previous.val) current.right = null;
            elements = collectKElements(current, k - distance, elements);
            distance++;
            previous = current;
        }
        return elements;
    }

    private LinkedList<TreeNode> findPathToTarget(TreeNode root, TreeNode target, LinkedList<TreeNode> path) {
        path.addLast(root);
        if (root.val == target.val) {
            return path;
        }
        if (root.left != null) {
            path = findPathToTarget(root.left, target, path);
            if (path.getLast().val == target.val) return path;
            else path.removeLast();
        }
        if (root.right != null) {
            path = findPathToTarget(root.right, target, path);
            if (path.getLast().val == target.val) return path;
            else path.removeLast();
        }
        return path;
    }

    private List<Integer> collectKElements(TreeNode root, int k, List<Integer> elements) {
        if (root == null) return elements;
        if (k == 0) {
            elements.add(root.val);
            return elements;
        }
        elements = collectKElements(root.left, k - 1, elements);
        elements = collectKElements(root.right, k - 1, elements);
        return elements;
    }
}
