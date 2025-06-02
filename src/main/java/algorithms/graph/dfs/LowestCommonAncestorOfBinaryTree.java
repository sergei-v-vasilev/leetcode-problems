package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. Lowest Common Ancestor of a Binary Tree
 *
 */
public class LowestCommonAncestorOfBinaryTree {

    /**
     * Time: O(|V| + log(|V|))
     * Space: O(|V|)
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = findPath(root, p, new ArrayList<>());
        for (int i = pathP.size() - 1; i >= 0; i--) {
            if (exists(pathP.get(i), q)) {
                return pathP.get(i);
            }
        }
        return null;
    }

    /**
     * Time: O(2|V|)
     * Space: O(2|V|)
     */
    public TreeNode lowestCommonAncestor2Paths(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = findPath(root, p, new ArrayList<>());
        List<TreeNode> pathQ = findPath(root, q, new ArrayList<>());
        int i = 0;
        while (i < pathP.size() && i < pathQ.size() && pathP.get(i).val == pathQ.get(i).val) {
            i++;
        }
        return i > 0 ? pathP.get(i - 1) : root;
    }

    private boolean exists(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return exists(root.left, p) || exists(root.right, p);
    }

    private List<TreeNode> findPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null) {
            return path;
        }
        path.add(root);
        if (root.val == p.val) {
            return path;
        } else {
            List<TreeNode> foundedPath = findPath(root.left, p, path);
            if (foundedPath.get(foundedPath.size() - 1).val == p.val) {
                return foundedPath;
            }
            foundedPath = findPath(root.right, p, path);
            if (foundedPath.get(foundedPath.size() - 1).val == p.val) {
                return foundedPath;
            }
            path.remove(path.size() - 1);
            return path;
        }
    }
}
