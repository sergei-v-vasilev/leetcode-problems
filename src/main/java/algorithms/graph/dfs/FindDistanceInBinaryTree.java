package algorithms.graph.dfs;

import algorithms.*;

import java.util.*;

/**
 * 1740. Find Distance in a Binary Tree
 */
public class FindDistanceInBinaryTree {

    public int findDistance(TreeNode root, int p, int q) {
        if (p == q) {
            return 0;
        }
        LinkedList<Integer> pPath = new LinkedList<>();
        LinkedList<Integer> qPath = new LinkedList<>();
        findPath(root, p, pPath);
        findPath(root, q, qPath);
        while (!pPath.isEmpty() && !qPath.isEmpty() && pPath.getFirst().equals(qPath.getFirst())) {
            pPath.removeFirst();
            qPath.removeFirst();
        }
        return pPath.size() + qPath.size();
    }

    private boolean findPath(TreeNode root, int value, LinkedList<Integer> path) {
        if (root == null) {
            return false;
        }
        path.addLast(root.val);
        if (root.val == value) {
            return true;
        }
        boolean wasFound = findPath(root.left, value, path);
        if (wasFound) {
            return true;
        }
        wasFound = findPath(root.right, value, path);
        if (wasFound) {
            return true;
        }
        path.removeLast();
        return false;
    }

}
