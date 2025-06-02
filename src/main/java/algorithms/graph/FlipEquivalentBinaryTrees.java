package algorithms.graph;

/**
 * 951. Flip Equivalent Binary Trees
 */
public class FlipEquivalentBinaryTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;
        if (root1 == null) return false;
        if (root2 == null) return false;
        if (root1.val != root2.val) return false;
        if (root1.left == null && root2.left == null && root1.right == null && root2.right == null) return true;
        //check for the same amount of non nulls
        if (root1.left != null && root1.right != null && (root2.left == null || root2.right == null)) return false;
        if (root2.left != null && root2.right != null && (root1.left == null || root1.right == null)) return false;
        if ((root1.left != null || root1.right != null) && (root2.left == null && root2.right == null)) return false;
        if ((root2.left != null || root2.right != null) && (root1.left == null && root1.right == null)) return false;
        //check values
        if (root1.left != null && root2.left != null && root1.right != null && root2.right != null) {
            //check left
            if (root1.left.val == root2.left.val) {
                if (!flipEquiv(root1.left, root2.left)) return false;
            } else if (root1.left.val == root2.right.val) {
                if (!flipEquiv(root1.left, root2.right)) return false;
            } else return false;
            //check right
            if (root1.right.val == root2.left.val) {
                if (!flipEquiv(root1.right, root2.left)) return false;
            } else if (root1.right.val == root2.right.val) {
                if (!flipEquiv(root1.right, root2.right)) return false;
            } else return false;
        } else if (root1.left != null && root2.left != null && root1.right == null && root2.right == null) {
            //check left
            if (root1.left.val == root2.left.val) {
                if (!flipEquiv(root1.left, root2.left)) return false;
            } else return false;
        } else if (root1.right != null && root2.right != null && root1.left == null && root2.left == null) {
            //check right
            if (root1.right.val == root2.right.val) {
                if (!flipEquiv(root1.right, root2.right)) return false;
            } else return false;
        } else if (root1.left != null && root2.right != null && root1.right == null && root2.left == null) {
            //check left
            if (root1.left.val == root2.right.val) {
                if (!flipEquiv(root1.left, root2.right)) return false;
            } else return false;
        } else if (root1.right != null && root2.left != null && root1.left == null && root2.right == null) {
            //check right
            if (root1.right.val == root2.left.val) {
                if (!flipEquiv(root1.right, root2.left)) return false;
            } else return false;
        }
        return true;
    }
}
