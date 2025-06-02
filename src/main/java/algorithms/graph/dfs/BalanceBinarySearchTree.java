package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class BalanceBinarySearchTree {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(list, root);
        return construct(0, list.size(), list);
    }

    private void inOrder(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            inOrder(list, node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            inOrder(list, node.right);
        }
    }

    private TreeNode construct(int start, int end, List<Integer> list) {
        if (start >= end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        int value = list.get(mid);
        TreeNode left = construct(start, mid, list);
        TreeNode right = construct(mid + 1, end, list);
        return new TreeNode(value, left, right);
    }
}
