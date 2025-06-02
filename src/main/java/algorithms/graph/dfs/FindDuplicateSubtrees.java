package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.*;

/**
 * 652. Find Duplicate Subtrees
 * Time: O(|E|+|V|)
 * Space: O(|V|)
 * <p>
 *
 */
public class FindDuplicateSubtrees {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        representTree(root, map, result);
        return result;
    }

    private String representTree(TreeNode root, Map<String, Integer> map, List<TreeNode> result) {
        if (root == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder(String.valueOf(root.val)).append(";");
        builder.append(representTree(root.left, map, result)).append(";");
        builder.append(representTree(root.right, map, result));
        String representation = builder.toString();
        int count = map.getOrDefault(representation, 0) + 1;
        map.put(representation, count);
        if (count == 2) {
            result.add(root);
        }
        return representation;
    }


}
