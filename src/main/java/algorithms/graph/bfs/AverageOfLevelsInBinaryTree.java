package algorithms.graph.bfs;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 637. Average of Levels in Binary Tree
 * Time: O(n)
 * Space: O(n)
 */
public class AverageOfLevelsInBinaryTree {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            long sum = 0, count = 0;
            LinkedList<TreeNode> temp = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode n = queue.poll();
                sum += n.val;
                count++;
                if (n.left != null) {
                    temp.add(n.left);
                }
                if (n.right != null) {
                    temp.add(n.right);
                }
            }
            queue = temp;
            result.add(sum * 1.0 / count);
        }
        return result;
    }
}
