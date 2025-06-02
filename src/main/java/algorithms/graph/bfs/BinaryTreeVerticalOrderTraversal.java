package algorithms.graph.bfs;

import algorithms.TreeNode;

import java.util.*;

/**
 * 314. Binary Tree Vertical Order Traversal
 */
public class BinaryTreeVerticalOrderTraversal {

    private static class ExtendedNode {
        private final TreeNode node;
        int column;

        public ExtendedNode(TreeNode node, int column) {
            this.node = node;
            this.column = column;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        int minColumn = 0;
        int maxColumn = 0;
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        LinkedList<ExtendedNode> queue = new LinkedList<>();
        queue.add(new ExtendedNode(root, 0));
        while (!queue.isEmpty()) {
            ExtendedNode currentNode = queue.pollFirst();
            List<Integer> list = columnMap.getOrDefault(currentNode.column, new LinkedList<>());
            list.add(currentNode.node.val);
            columnMap.put(currentNode.column, list);
            maxColumn = Math.max(maxColumn, currentNode.column);
            minColumn = Math.min(minColumn, currentNode.column);
            if (currentNode.node.left != null) {
                queue.add(new ExtendedNode(currentNode.node.left, currentNode.column - 1));
            }
            if (currentNode.node.right != null) {
                queue.add(new ExtendedNode(currentNode.node.right, currentNode.column + 1));
            }
        }

        List<Integer>[] result = new LinkedList[maxColumn - minColumn + 1];
        for (int column : columnMap.keySet()) {
            result[column - minColumn] = columnMap.get(column);
        }
        return Arrays.stream(result).toList();
    }


}
