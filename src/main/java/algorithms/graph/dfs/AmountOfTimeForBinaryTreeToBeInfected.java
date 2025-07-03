package algorithms.graph.dfs;

import algorithms.*;
import java.util.*;

/**
 * 2385. (M). Amount of Time for Binary Tree to Be Infected
 */
public class AmountOfTimeForBinaryTreeToBeInfected {

    private class TreeNodeWithParent {
        int value;
        boolean infected = false;

        TreeNodeWithParent parent;
        TreeNodeWithParent left;
        TreeNodeWithParent right;

        public TreeNodeWithParent(TreeNode node, TreeNodeWithParent parent) {
            this.value = node.val;
            this.parent = parent;
        }
    }

    public int amountOfTime(TreeNode root, int start) {
        TreeNodeWithParent rootWithParent = buildTree(root, null);
        if (start == rootWithParent.value) {
            return findDepth(rootWithParent) - 1;
        }
        TreeNodeWithParent startNode = findNode(rootWithParent, start);
        if (startNode == null) {
            return -1;
        }

        LinkedList<TreeNodeWithParent> queue = new LinkedList<>();
        queue.add(startNode);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNodeWithParent node = queue.removeFirst();
                node.infected = true;
                if (node.parent != null && !node.parent.infected) {
                    queue.add(node.parent);
                }
                if (node.left != null && !node.left.infected) {
                    queue.add(node.left);
                }
                if (node.right != null && !node.right.infected) {
                    queue.add(node.right);
                }
            }
            time++;
        }
        return time - 1;
    }

    private TreeNodeWithParent buildTree(TreeNode root, TreeNodeWithParent parent) {
        if (root == null) {
            return null;
        }
        TreeNodeWithParent node = new TreeNodeWithParent(root, parent);
        node.left = buildTree(root.left, node);
        node.right = buildTree(root.right, node);
        return node;
    }

    private TreeNodeWithParent findNode(TreeNodeWithParent node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        TreeNodeWithParent left = findNode(node.left, value);
        if (left != null) {
            return left;
        }
        return findNode(node.right, value);
    }

    private int findDepth(TreeNodeWithParent node) {
        if (node == null) {
            return 0;
        }
        int left = findDepth(node.left);
        int right = findDepth(node.right);
        return Math.max(left, right) + 1;
    }

}
