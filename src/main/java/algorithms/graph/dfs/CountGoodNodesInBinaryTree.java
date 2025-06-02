package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 1448. Count Good Nodes in Binary Tree
 *
 */
public class CountGoodNodesInBinaryTree {
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    private int goodNodes(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int countGoodNodes = 0;
        if (root.val >= max) {
            max = root.val;
            countGoodNodes++;
        }
        countGoodNodes += goodNodes(root.left, max);
        countGoodNodes += goodNodes(root.right, max);
        return countGoodNodes;
    }
}
