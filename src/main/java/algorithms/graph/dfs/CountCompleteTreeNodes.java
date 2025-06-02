package algorithms.graph.dfs;


import algorithms.TreeNode;

/**
 * 222. Count Complete Tree Nodes
 * Time: O(log^2(n))
 * Space: O(1)
 *
 */
public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        TreeNode node = root;
        int leftHeight = 0;
        while (node != null) {
            node = node.left;
            leftHeight++;
        }
        node = root;
        int rightHeight = 0;
        while (node != null) {
            node = node.right;
            rightHeight++;
        }
        if (leftHeight == rightHeight) {
            return (int) (Math.pow(2, leftHeight) - 1);
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
}
