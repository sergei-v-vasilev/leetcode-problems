package algorithms.graph.dfs;


import java.util.LinkedList;
import java.util.List;

/**
 * 428. Serialize and Deserialize N-ary Tree
 */
class Codec {
    private class CodecNode {
        Node node;
        int index;

        public CodecNode(Node node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(Node root) {
        return serialize(root, new StringBuilder()).toString();
    }

    public StringBuilder serialize(Node root, StringBuilder builder) {
        if (root == null) {
            return builder;
        }
        builder.append(root.val);
        if (root.children == null || root.children.isEmpty()) {
            builder.append("()");
            return builder;
        }
        builder.append("(");
        for (Node child : root.children) {
            builder = serialize(child, builder);
            builder.append(",");
        }
        builder.delete(builder.length() - 1, builder.length());
        builder.append(")");
        return builder;
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        return deserialize(0, data.toCharArray()).node;
    }

    private CodecNode deserialize(int i, char[] data) {
        StringBuilder number = new StringBuilder();
        int k = i;
        while (k < data.length && Character.isDigit(data[k])) {
            number.append(data[k]);
            k++;
        }
        int nodeValue = Integer.parseInt(number.toString());
        if (data[k] != '(') {
            throw new IllegalArgumentException("invalid data: expected (, found " + data[k]);
        }
        k++;
        if (data[k] == ')') {
            return new CodecNode(new Node(nodeValue, new LinkedList<>()), k + 1);
        }
        List<Node> children = new LinkedList<>();
        while (k < data.length && data[k] != ')') {
            CodecNode node = deserialize(k, data);
            children.add(node.node);
            k = node.index;
            if (k < data.length && data[k] == ',') {
                k++;
            }
        }
        return new CodecNode(new Node(nodeValue, children), k + 1);
    }

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}