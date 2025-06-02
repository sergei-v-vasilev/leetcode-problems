package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 653. Two Sum IV - Input is a BST
 * Time: O(n)
 * Space: O(n)
 *
 */
public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> numbers = new HashSet<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pollFirst();
            if (numbers.contains(k - node.val)) {
                return true;
            }
            numbers.add(node.val);
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return false;
    }
}
