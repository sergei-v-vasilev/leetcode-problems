package algorithms.graph.dfs;


import java.util.HashSet;
import java.util.Set;

/**
 * 1261. Find Elements in a Contaminated Binary Tree
 */
class FindElements {

    private final Set<Integer> elements;

    public FindElements(TreeNode root) {
        elements = new HashSet<>();
        dfs(0, root);
    }

    public boolean find(int target) {
        return elements.contains(target);
    }

    private void dfs(int x, TreeNode root) {
        root.val = x;
        elements.add(x);
        if (root.left != null) {
            dfs(2 * x + 1, root.left);
        }
        if (root.right != null) {
            dfs(2 * x + 2, root.right);
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}