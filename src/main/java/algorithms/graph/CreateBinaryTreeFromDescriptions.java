package algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2196. Create Binary Tree From Descriptions
 */
public class CreateBinaryTreeFromDescriptions {

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


    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        Set<Integer> hasParentSet = new HashSet<>();
        for (int[] description : descriptions) {
            TreeNode parent = nodeMap.getOrDefault(description[0], new TreeNode(description[0]));
            TreeNode child = nodeMap.getOrDefault(description[1], new TreeNode(description[1]));
            if (description[2] == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }
            nodeMap.put(description[0], parent);
            nodeMap.put(description[1], child);
            hasParentSet.add(description[1]);
        }
        for (Integer key : nodeMap.keySet()) {
            if (!hasParentSet.contains(key)) {
                return nodeMap.get(key);
            }
        }
        throw new IllegalArgumentException("No binary tree found");
    }
}
