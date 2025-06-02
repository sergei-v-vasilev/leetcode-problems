package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1302. Deepest Leaves Sum
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class DeepestLeavesSum {

    public int deepestLeavesSum(TreeNode root) {
        if (root == null) return 0;
        Map<TreeNode, Integer> map = new HashMap<>();
        findLeaves(root, 0, map);
        int max = Integer.MIN_VALUE;
        for (TreeNode node : map.keySet()) {
            max = Math.max(max, map.get(node));
        }
        int sum = 0;
        for (TreeNode node : map.keySet()) {
            if (map.get(node) == max) {
                sum += node.val;
            }
        }
        return sum;
    }

    private void findLeaves(TreeNode root, int numberOfNodes, Map<TreeNode, Integer> map) {
        if (root.left == null && root.right == null) {
            map.put(root, numberOfNodes + 1);
        } else if (root.left != null && root.right != null) {
            findLeaves(root.left, numberOfNodes + 1, map);
            findLeaves(root.right, numberOfNodes + 1, map);
        } else if (root.left != null) {
            findLeaves(root.left, numberOfNodes + 1, map);
        } else {
            findLeaves(root.right, numberOfNodes + 1, map);
        }
    }
}
