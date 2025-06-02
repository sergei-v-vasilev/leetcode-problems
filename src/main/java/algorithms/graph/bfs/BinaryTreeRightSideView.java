package algorithms.graph.bfs;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 199. Binary Tree Right Side View
 *
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int sizeOfRow = 1;
        TreeNode currentNode = null;
        while (!queue.isEmpty()) {
            if (sizeOfRow == 0) {
                sizeOfRow = queue.size();
                result.add(currentNode.val);
            }
            currentNode = queue.pollFirst();
            sizeOfRow--;
            if (currentNode.left != null) {
                queue.addLast(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.addLast(currentNode.right);
            }
        }
        result.add(currentNode.val);
        return result;
    }
}
