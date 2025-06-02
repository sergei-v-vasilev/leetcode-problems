package algorithms.dp.top;

import algorithms.TreeNode;

import java.util.*;

/**
 * 894. All Possible Full Binary Trees
 * Time: O(2^n)
 * Space: O(2^n)
 *
 */
public class AllPossibleFullBinaryTrees {
    public List<TreeNode> allPossibleFBT(int n) {
        if (n % 2 == 0) {
            return new ArrayList<>();
        }
        Map<Integer, List<TreeNode>> memo = new HashMap<>(n);
        memo.put(1, List.of(new TreeNode(0)));
        return allPossibleFBT(n, memo);
    }

    private List<TreeNode> allPossibleFBT(int n, Map<Integer, List<TreeNode>> memo) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        List<TreeNode> result = new ArrayList<>();
        for (int i = 1; i < n - 1; i = i + 2) {
            List<TreeNode> leftNodes = allPossibleFBT(i, memo);
            List<TreeNode> rightNodes = allPossibleFBT(n - 1 - i, memo);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    result.add(new TreeNode(0, leftNode, rightNode));
                }
            }
        }
        memo.put(n, result);
        return result;
    }
}
