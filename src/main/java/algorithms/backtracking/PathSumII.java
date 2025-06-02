package algorithms.backtracking;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 113. Path Sum II
 * Time: O(|E|+|V|)
 * Space: O(|V|)
 * <p>
 *
 */
public class PathSumII {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        LinkedList<Integer> path = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        path.add(root.val);
        return pathSum(root, targetSum, path, result);
    }

    private List<List<Integer>> pathSum(TreeNode root, int targetSum, LinkedList<Integer> currentPath, List<List<Integer>> result) {
        if (root == null) {
            return result;
        }
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                result.add(new ArrayList<>(currentPath));
            }
            return result;
        }
        if (root.left != null) {
            currentPath.add(root.left.val);
            result = pathSum(root.left, targetSum - root.val, currentPath, result);
            currentPath.removeLast();
        }
        if (root.right != null) {
            currentPath.add(root.right.val);
            result = pathSum(root.right, targetSum - root.val, currentPath, result);
            currentPath.removeLast();
        }
        return result;
    }
}
