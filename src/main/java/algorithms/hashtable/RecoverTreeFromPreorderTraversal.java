package algorithms.hashtable;

import algorithms.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1028. Recover a Tree From Preorder Traversal
 * Time: O(n)
 * Space: O(n)
 *
 */
public class RecoverTreeFromPreorderTraversal {

    public TreeNode recoverFromPreorder(String traversal) {
        TreeNode root = null;
        Map<Integer, TreeNode> parentMap = new HashMap<>();
        int i = 0;
        while (i < traversal.length()) {
            StringBuilder digits = new StringBuilder();
            int depth = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                digits.append(traversal.charAt(i));
                i++;
            }
            int value = Integer.parseInt(digits.toString());
            if (parentMap.containsKey(depth - 1)) {
                TreeNode parent = parentMap.get(depth - 1);
                if (parent.left == null) {
                    parent.left = new TreeNode(value);
                    parentMap.put(depth, parent.left);
                } else {
                    parent.right = new TreeNode(value);
                    parentMap.put(depth, parent.right);
                }
            } else {
                root = new TreeNode(value);
                parentMap.put(depth, root);
            }
        }
        return root;
    }

}
