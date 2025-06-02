package algorithms.graph;

import algorithms.TreeNode;

/**
 * 606. Construct String from Binary Tree
 *
 */
public class ConstructStringFromBinaryTree {
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        builder.append(root.val);
        if (root.left == null && root.right == null) {
            return builder.toString();
        } else if (root.left != null && root.right == null) {
            builder.append("(").append(tree2str(root.left)).append(")");
            return builder.toString();
        } else {
            builder.append("(").append(tree2str(root.left)).append(")");
            builder.append("(").append(tree2str(root.right)).append(")");
            return builder.toString();
        }
    }
}
