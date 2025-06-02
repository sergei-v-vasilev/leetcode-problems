package algorithms.graph.dfs;


import algorithms.TreeNode;

/**
 * 865. Smallest Subtree with all the Deepest Nodes
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class SmallestSubtreeWithAllDeepestNodes {

    private class ParentNode {
        int depth;
        TreeNode node;

        ParentNode(TreeNode node, int depth) {
            this.depth = depth;
            this.node = node;
        }
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        ParentNode parentNode = findAllLeaves(root, 0);
        return parentNode.node;
    }

    private ParentNode findAllLeaves(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return new ParentNode(root, depth);
        } else if (root.left != null && root.right != null) {
            ParentNode left = findAllLeaves(root.left, depth + 1);
            ParentNode right = findAllLeaves(root.right, depth + 1);
            if (left.depth == right.depth && !left.node.equals(right.node)) {
                return new ParentNode(root, left.depth);
            }
            return left.depth < right.depth ? right : left;
        } else if (root.left != null) {
            return findAllLeaves(root.left, depth + 1);
        } else {
            return findAllLeaves(root.right, depth + 1);
        }
    }

}
