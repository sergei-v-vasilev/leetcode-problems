package algorithms.graph;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(0, postorder.length, 0, postorder, inorderMap);
    }

    private TreeNode buildTree(int start, int end, int startInorder, int[] postorder, Map<Integer, Integer> inorder) {
        if (start == end) {
            return null;
        }
        int rootValue = postorder[end - 1];
        int index = inorder.get(rootValue);
        TreeNode root = new TreeNode(rootValue);
        root.left = buildTree(start, start + index - startInorder, startInorder, postorder, inorder);
        root.right = buildTree(start + index - startInorder, end - 1, index + 1, postorder, inorder);
        return root;
    }
}
