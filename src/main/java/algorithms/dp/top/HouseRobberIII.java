package algorithms.dp.top;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. House Robber III
 */
public class HouseRobberIII {

    public int rob(TreeNode root) {
        return rob(root, new HashMap<>());
    }

    private int rob(TreeNode root, Map<TreeNode, Integer> memo) {
        if (root == null) {
            return 0;
        }
        if (memo.containsKey(root)) {
            return memo.get(root);
        }
        int result;
        int resultWithRoot;
        if (root.left == null && root.right == null) {
            resultWithRoot = root.val;
        } else if (root.left == null) {
            resultWithRoot = root.val + rob(root.right.left, memo) + rob(root.right.right, memo);
        } else if (root.right == null) {
            resultWithRoot = root.val + rob(root.left.left, memo) + rob(root.left.right, memo);
        } else {
            resultWithRoot = root.val + rob(root.left.left, memo) + rob(root.left.right, memo)
                    + rob(root.right.left, memo) + rob(root.right.right, memo);
        }
        int resultWithoutRoot = rob(root.left, memo) + rob(root.right, memo);
        result = Math.max(resultWithoutRoot, resultWithRoot);
        memo.put(root, result);
        return result;
    }
}
