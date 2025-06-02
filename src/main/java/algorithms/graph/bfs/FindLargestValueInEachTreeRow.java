package algorithms.graph.bfs;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 515. Find Largest Value in Each Tree Row
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        int localMax;
        TreeNode current;
        int size;
        queue.add(root);
        while (!queue.isEmpty()) {
            size = queue.size();
            localMax = Integer.MIN_VALUE;
            while (size > 0 && !queue.isEmpty()) {
                current = queue.pollFirst();
                localMax = Math.max(localMax, current.val);
                size--;
                if (current.left != null) queue.addLast(current.left);
                if (current.right != null) queue.addLast(current.right);
            }
            result.add(localMax);
        }
        return result;
    }
}
