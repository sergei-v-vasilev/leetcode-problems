package algorithms.graph.dfs;

import algorithms.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 * Time: O(2|V|)
 * Space: O(2|V|)
 * 
 */
public class StepByStepDirectionsFromBinaryTreeNodeToAnother {

    private class TreeNodeWithDirection {
        Character direction;
        TreeNode treeNode;

        public TreeNodeWithDirection(Character direction, TreeNode treeNode) {
            this.direction = direction;
            this.treeNode = treeNode;
        }
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<TreeNodeWithDirection> pathS = findPath(root, startValue, new ArrayList<>(), null);
        List<TreeNodeWithDirection> pathE = findPath(root, destValue, new ArrayList<>(), null);
        int i = 0;
        while (i < pathS.size() && i < pathE.size() && pathS.get(i).treeNode.val == pathE.get(i).treeNode.val) {
            i++;
        }
        i--;
        StringBuilder builder = new StringBuilder();
        for (int j = 0; j < pathS.size() - i; j++) {
            builder.append("U");
        }
        for (int j = i; j < pathE.size(); j++) {
            if (pathE.get(j).direction == 'L') {
                builder.append("L");
            } else {
                builder.append("R");
            }
        }
        return builder.toString();
    }


    private List<TreeNodeWithDirection> findPath(TreeNode root, int startValue, List<TreeNodeWithDirection> path, Character direction) {
        if (root == null) {
            return path;
        }
        path.add(new TreeNodeWithDirection(direction, root));
        if (root.val == startValue) {
            return path;
        }
        path = findPath(root.left, startValue, path, 'L');
        if (path.get(path.size() - 1).treeNode.val == startValue) {
            return path;
        }
        path = findPath(root.right, startValue, path, 'R');
        if (path.get(path.size() - 1).treeNode.val == startValue) {
            return path;
        }
        path.remove(path.size() - 1);
        return path;
    }
}
