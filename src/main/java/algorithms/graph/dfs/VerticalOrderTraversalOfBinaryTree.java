package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.*;

/**
 * 987. Vertical Order Traversal of a Binary Tree
 *
 */
public class VerticalOrderTraversalOfBinaryTree {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int left = Math.min(0, findLeft(root, 0));
        int right = findRight(root, 0);
        List<List<TreeNode>> nodes = new ArrayList<>(right - left + 1);
        for (int i = 0; i < right - left + 1; i++) {
            nodes.add(new LinkedList<>());
        }
        Map<TreeNode, Integer> rowMap = new HashMap<>();
        fill(root, left, nodes, 0, 0, rowMap);
        List<List<Integer>> result = new ArrayList<>(right - left + 1);
        for (int i = 0; i < right - left + 1; i++) {
            List<TreeNode> values = nodes.get(i);
            values.sort((l, r) -> {
                int lRow = rowMap.get(l);
                int rRow = rowMap.get(r);
                if (lRow == rRow) {
                    return Integer.compare(l.val, r.val);
                } else {
                    return Integer.compare(lRow, rRow);
                }
            });
            List<Integer> resultValues = new ArrayList<>(values.size());
            for (TreeNode node : values) {
                resultValues.add(node.val);
            }
            result.add(resultValues);
        }
        return result;
    }

    private void fill(TreeNode root, int left, List<List<TreeNode>> result, int value, int row,
                      Map<TreeNode, Integer> rowMap) {
        int position = value - left;
        List<TreeNode> values = result.get(position);
        values.add(root);
        rowMap.put(root, row);
        if (root.left != null) {
            fill(root.left, left, result, value - 1, row + 1, rowMap);
        }
        if (root.right != null) {
            fill(root.right, left, result, value + 1, row + 1, rowMap);
        }
    }

    private int findLeft(TreeNode root, int value) {
        if (root.left == null && root.right == null) {
            return value;
        } else if (root.left == null) {
            return Math.min(value, findLeft(root.right, value + 1));
        } else if (root.right == null) {
            return Math.min(value, findLeft(root.left, value - 1));
        } else {
            return Math.min(value, Math.min(findLeft(root.left, value - 1), findLeft(root.right, value + 1)));
        }
    }

    private int findRight(TreeNode root, int value) {
        if (root.left == null && root.right == null) {
            return value;
        } else if (root.left == null) {
            return Math.max(value, findRight(root.right, value + 1));
        } else if (root.right == null) {
            return Math.max(value, findRight(root.left, value - 1));
        } else {
            return Math.max(value, Math.max(findRight(root.left, value - 1), findRight(root.right, value + 1)));
        }
    }
}
