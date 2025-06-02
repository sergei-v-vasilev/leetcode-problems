package algorithms.graph.bfs;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Time: O(n)
 * Space: O(n)
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        boolean fromLeft = true;
        List<Integer> currentRow = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode currentNode;
        int sizeOfRow = 1;
        while (!queue.isEmpty()) {
            if (sizeOfRow == 0) {
                sizeOfRow = queue.size();
                fromLeft = !fromLeft;
                result.add(currentRow);
                currentRow = new ArrayList<>();
            }
            currentNode = fromLeft ? queue.pollLast() : queue.pollFirst();
            currentRow.add(currentNode.val);
            if (fromLeft) {
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.addFirst(currentNode.right);
                }
            } else {
                if (currentNode.right != null) {
                    queue.addFirst(currentNode.right);
                }
                if (currentNode.left != null) {
                    queue.addFirst(currentNode.left);
                }
            }
            sizeOfRow--;
        }
        result.add(currentRow);
        return result;
    }
}
