package algorithms.graph.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2246. Longest Path With Different Adjacent Characters
 */
public class LongestPathWithDifferentAdjacentCharacters {

    int max = 1;

    private class TreeNode {
        int val;
        char letter;
        Set<Integer> children;

        public TreeNode(int val) {
            this.val = val;
            this.children = new HashSet<>();
        }
    }

    public int longestPath(int[] parent, String s) {
        max = 1;
        int n = parent.length;
        Map<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(0);
        root.letter = s.charAt(0);
        map.put(0, root);
        for (int i = 1; i < n; i++) {
            map.put(i, new TreeNode(i));
        }
        for (int i = 1; i < n; i++) {
            int parentId = parent[i];
            TreeNode node = map.get(i);
            node.letter = s.charAt(i);
            map.get(parentId).children.add(i);
        }
        dfs(root, '0', map);
        return max;
    }

    private int dfs(TreeNode root, char previousLetter, Map<Integer, TreeNode> map) {
        if (root == null) return 0;
        if (root.children.isEmpty()) {
            return root.letter == previousLetter ? 0 : 1;
        }
        int firstMax = 0;
        int secondMax = 0;
        for (Integer childId : root.children) {
            TreeNode node = map.get(childId);
            int length = dfs(node, root.letter, map);
            if (firstMax < length) {
                secondMax = firstMax;
                firstMax = length;
            } else if (secondMax < length) {
                secondMax = length;
            }
        }
        max = Math.max(max, 1 + firstMax + secondMax);
        if (root.letter == previousLetter) {
            return 0;
        }
        return 1 + firstMax;
    }

}
