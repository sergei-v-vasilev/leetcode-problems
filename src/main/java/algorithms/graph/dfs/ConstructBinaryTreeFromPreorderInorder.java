package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Time: O(n)
 * Space: O(n)
 */
public class ConstructBinaryTreeFromPreorderInorder {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return constructTree(0, preorder.length, preorder, 0, map);
    }

    private TreeNode constructTree(int start, int end, int[] preorder, int inorderStart, Map<Integer, Integer> inorder) {
        if (start < end) {
            int rootValue = preorder[start];
            TreeNode root = new TreeNode(rootValue);
            if (start + 1 < end) {
                int leftValue = preorder[start + 1];
                int rightIndex = inorder.get(rootValue) + start - inorderStart + 1;
                if (inorder.get(rootValue) == 1 && inorder.get(leftValue) == 0) {
                    root.left = new TreeNode(leftValue);
                } else {
                    root.left = constructTree(start + 1, rightIndex, preorder, inorderStart, inorder);
                }
                if (start <= rightIndex && rightIndex < end && rightIndex == end - 1) {
                    root.right = new TreeNode(preorder[rightIndex]);
                } else if (start <= rightIndex && rightIndex < end) {
                    root.right = constructTree(rightIndex, end, preorder, inorder.get(rootValue) + 1, inorder);
                }
            }
            return root;
        } else {
            return null;
        }

    }
}
