package algorithms.graph.bfs;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 107. Binary Tree Level Order Traversal II
 * Time: O(n)
 * Space: O(n*h)
 *
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        LinkedList<TreeNode> rootQueue = new LinkedList<>();
        LinkedList<TreeNode> leafQueue = new LinkedList<>();
        if (root != null) {
            rootQueue.addLast(root);
        }
        TreeNode node;
        List<Integer> line;
        while (!rootQueue.isEmpty()) {
            line = new LinkedList<>();
            while (!rootQueue.isEmpty()) {
                node = rootQueue.pollFirst();
                line.add(node.val);
                if (node.left != null) {
                    leafQueue.addLast(node.left);
                }
                if (node.right != null) {
                    leafQueue.addLast(node.right);
                }
            }
            result.addFirst(line);
            rootQueue = leafQueue;
            leafQueue = new LinkedList<>();
        }
        return result;
    }

}
