package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 129. Sum Root to Leaf Numbers
 * Time: O(n)
 * Space: O(n)
 *
 */
public class SumRootToLeafNumbers {

    private int sum = 0;

    public int sumNumbers(TreeNode root) {
        sumNumbers(root, 0);
        return sum;
    }

    private void sumNumbers(TreeNode root, int number) {
        if (root.left == null && root.right == null) {
            sum += number * 10 + root.val;
        } else {
            if (root.left != null) {
                sumNumbers(root.left, number * 10 + root.val);
            }
            if (root.right != null) {
                sumNumbers(root.right, number * 10 + root.val);
            }
        }
    }
}
