package algorithms.graph.bfs;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 102. Binary Tree Level Order Traversal
 * Time: O(n)
 * Space: O(n)
 *
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        List<Integer> row;
        LinkedList<TreeNode> queue = new LinkedList<>();
        int size;
        queue.add(root);
        while (!queue.isEmpty()) {
            row = new LinkedList<>();
            size = queue.size();
            while (size > 0) {
                TreeNode node = queue.pollFirst();
                size--;
                row.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
            result.add(row);
        }
        return result;
    }

}
