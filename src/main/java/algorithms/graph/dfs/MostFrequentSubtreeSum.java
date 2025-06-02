package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 508. Most Frequent Subtree Sum
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class MostFrequentSubtreeSum {
    private final Map<Integer, Integer> frequencyMap = new HashMap<>();
    private int max = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        findFrequency(root);
        Set<Integer> mostFrequentSum = frequencyMap.keySet()
                .stream()
                .filter(key -> frequencyMap.get(key) == max)
                .collect(Collectors.toSet());
        int[] result = new int[mostFrequentSum.size()];
        int i = 0;
        for (int key : mostFrequentSum) {
            result[i] = key;
            i++;
        }
        return result;
    }

    private int findFrequency(TreeNode root) {
        int value;
        if (root.left == null && root.right == null) {
            value = root.val;
        } else {
            int left = root.left == null ? 0 : findFrequency(root.left);
            int right = root.right == null ? 0 : findFrequency(root.right);
            value = left + right + root.val;
        }
        int frequency = frequencyMap.getOrDefault(value, 0) + 1;
        frequencyMap.put(value, frequency);
        max = Math.max(max, frequency);
        return value;
    }


}
