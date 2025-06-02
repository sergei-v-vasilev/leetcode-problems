package algorithms.graph.dfs;

import algorithms.TreeNode;

/**
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * Time: O(n)
 * Space: O(n)
 *
 */
public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < q.val) {
            if (p.val <= root.val && root.val <= q.val) {
                return root;
            } else if (root.val < p.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return lowestCommonAncestor(root.left, p, q);
            }
        } else {
            return lowestCommonAncestor(root, q, p);
        }
    }
}
