package algorithms.backtracking;

import algorithms.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 257. Binary Tree Paths
 * Time: O(n)
 * Space: O(n)
 *
 */
public class BinaryTreePaths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> allPaths = new LinkedList<>();
        binaryTreePaths(root, new StringBuilder(), allPaths);
        return allPaths;
    }

    public void binaryTreePaths(TreeNode root, StringBuilder path, List<String> allPaths) {
        path.append(root.val);
        if (root.left == null && root.right == null) {
            allPaths.add(path.toString());
        }
        if (root.left != null) {
            binaryTreePaths(root.left, new StringBuilder(path).append("->"), allPaths);
        }
        if (root.right != null) {
            binaryTreePaths(root.right, new StringBuilder(path).append("->"), allPaths);
        }
    }
}
