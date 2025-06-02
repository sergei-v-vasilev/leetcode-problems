package algorithms.graph.dfs;

import algorithms.*;

/**
 * 536. Construct Binary Tree from String
 */
public class ConstructBinaryTreeFromString {

    private class ExtendedTreeNode {
        TreeNode root;
        int index;

        public ExtendedTreeNode(TreeNode root, int index) {
            this.root = root;
            this.index = index;
        }
    }

    public TreeNode str2tree(String s) {
        ExtendedTreeNode root = str2tree(0, s);
        return root == null ? null : root.root;
    }

    private ExtendedTreeNode str2tree(int i, String s) {
        if (i >= s.length()) return null;
        int sign = 1;
        if (s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        StringBuilder valueBuilder = new StringBuilder();
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            valueBuilder.append(s.charAt(i));
            i++;
        }
        int value = sign * Integer.parseInt(valueBuilder.toString());
        int leftMost = i + 1;
        TreeNode node = new TreeNode(value);
        if (i >= s.length()) return new ExtendedTreeNode(node, i);
        if (s.charAt(i) == '(') {
            ExtendedTreeNode left = str2tree(i + 1, s);
            node.left = left == null ? null : left.root;
            leftMost = left != null ? left.index + 1 : i + 1;
            if (left != null && left.index < s.length() && s.charAt(left.index) == '(') {
                ExtendedTreeNode right = str2tree(left.index + 1, s);
                node.right = right == null ? null : right.root;
                leftMost = right != null ? right.index + 1 : i + 1;
            }
        }
        return new ExtendedTreeNode(node, leftMost);
    }


}
