package algorithms.graph;

import algorithms.TreeNode;

/**
 * 889. Construct Binary Tree from Preorder and Postorder Traversal
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    private int preIndex = 0;
    private int postIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder);
    }

    private TreeNode constructTree(int[] preorder, int[] postorder) {
        TreeNode root = new TreeNode(preorder[preIndex++]);
        if (root.val != postorder[postIndex]) {
            root.left = constructTree(preorder, postorder);
        }
        if (root.val != postorder[postIndex]) {
            root.right = constructTree(preorder, postorder);
        }
        postIndex++;
        return root;
    }

}
