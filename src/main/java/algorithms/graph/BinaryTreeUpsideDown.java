package algorithms.graph;


import algorithms.TreeNode;

/**
 * 156. Binary Tree Upside Down
 * https://medium.com/@hiimdaosui/binary-tree-upside-down-77af203c79af
 *
 */
public class BinaryTreeUpsideDown {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode last = new TreeNode(root.val);
        TreeNode current;
        while (root.left != null) {
            current = new TreeNode(root.left.val);
            current.left = new TreeNode(root.right.val);
            current.right = last;
            last = current;
            root = root.left;
        }
        return last;
    }

}
