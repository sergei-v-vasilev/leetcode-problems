package algorithms.graph.dfs;


import algorithms.TreeNode;

/**
 * 297. Serialize and Deserialize Binary Tree
 * Time: O(|V|)
 * Space: O(|V|)
 *
 */
public class SerializeAndDeserializeBinaryTree {
    private static class IndexedTreeNode {
        TreeNode node;
        int i;

        public IndexedTreeNode(int i, TreeNode node) {
            this.node = node;
            this.i = i;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = serialize(root, new StringBuilder());
        return builder.toString();
    }

    private StringBuilder serialize(TreeNode root, StringBuilder builder) {
        if (root == null) {
            return builder.append(",");
        } else {
            builder.append(root.val).append(",");
            builder = serialize(root.left, builder);
            return serialize(root.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        return deserialize(0, values).node;
    }

    private IndexedTreeNode deserialize(int i, String[] values) {
        if (i >= values.length || "".equals(values[i])) {
            return new IndexedTreeNode(i, null);
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[i]));
        IndexedTreeNode left = deserialize(i + 1, values);
        IndexedTreeNode right = deserialize(left.i + 1, values);
        node.left = left.node;
        node.right = right.node;
        return new IndexedTreeNode(right.i, node);
    }
}
