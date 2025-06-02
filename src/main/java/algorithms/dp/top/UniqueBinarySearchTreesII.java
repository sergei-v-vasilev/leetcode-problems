package algorithms.dp.top;

import algorithms.TreeNode;

import java.util.*;

/**
 * 95. Unique Binary Search Trees II
 * Time: O(n)
 * Space: O(n)
 *
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        Map<Integer, Map<Integer, List<TreeNode>>> memo = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            Map<Integer, List<TreeNode>> memoNodes = memo.getOrDefault(i, new HashMap<>());
            memoNodes.put(i + 1, List.of(new TreeNode(i)));
            memo.put(i, memoNodes);
        }
        return numTrees(1, n + 1, memo);
    }

    private List<TreeNode> numTrees(int start, int end, Map<Integer, Map<Integer, List<TreeNode>>> memo) {
        if (end == start) {
            TreeNode node = null;
            return Arrays.asList(node);
        }
        if (memo.containsKey(start) && memo.get(start).containsKey(end)) {
            return memo.get(start).get(end);
        }
        List<TreeNode> nodes = new LinkedList<>();
        for (int i = start; i < end; i++) {
            for (TreeNode left : numTrees(start, i, memo)) {
                for (TreeNode right : numTrees(i + 1, end, memo)) {
                    nodes.add(new TreeNode(i, left, right));
                }
            }
        }
        Map<Integer, List<TreeNode>> memoNodes = memo.getOrDefault(start, new HashMap<>());
        memoNodes.put(end, nodes);
        memo.put(start, memoNodes);
        return nodes;
    }
}
