package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. Path Sum III
 *
 */
public class PathSumIII {

    /**
     * Time: O(n)
     * Space: O(n)
     */
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(0, 1);
        return dfs(root, 0, targetSum, cache);
    }

    private int dfs(TreeNode root, int sum, int targetSum, Map<Integer, Integer> cache) {
        if (root == null) return 0;
        sum += root.val;
        int result = 0;
        result += cache.getOrDefault(sum - targetSum, 0);
        cache.put(sum, cache.getOrDefault(sum, 0) + 1);
        result += dfs(root.left, sum, targetSum, cache) + dfs(root.right, sum, targetSum, cache);
        cache.put(sum, cache.getOrDefault(sum, 0) - 1);
        return result;
    }


    /**
     * Time: O(n^2)
     * Space: O(n^2)
     */
    public int pathSumQuadratic(TreeNode root, int targetSum) {
        if (root == null) return 0;
        return countPathSumFromRoot(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    private int countPathSumFromRoot(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        } else {
            int count = root.val == targetSum ? 1 : 0;
            int value = targetSum - root.val;
            return count + countPathSumFromRoot(root.left, value) + countPathSumFromRoot(root.right, value);
        }
    }
}
