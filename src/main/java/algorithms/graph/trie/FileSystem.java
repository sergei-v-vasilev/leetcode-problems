package algorithms.graph.trie;

import java.util.*;

/**
 * 588. Design In-Memory File System
 */
public class FileSystem {

    private interface Node extends Comparable<Node> {
        String getName();

        @Override
        default int compareTo(Node o) {
            return getName().compareTo(o.getName());
        }
    }

    private class Directory implements Node {
        protected String name;
        protected Map<String, Node> children;

        public Directory(String name) {
            this.name = name;
            this.children = new TreeMap<>();
        }

        @Override
        public String getName() {
            return name;
        }
    }

    private class File implements Node {
        protected String name;
        protected String content;

        public File(String name) {
            this.name = name;
            this.content = "";
        }

        public void addContent(String content) {
            this.content += content;
        }

        public String getContent() {
            return content;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    private Directory root;

    public FileSystem() {
        this.root = new Directory("");
    }

    public List<String> ls(String path) {
        if ("/".equals(path)) {
            return root.children.keySet().stream().toList();
        }
        return ls(root, 1, path.split("/"));
    }

    private List<String> ls(Directory parent, int i, String[] path) {
        if (i == path.length - 1) {
            Node node = parent.children.get(path[i]);
            if (node instanceof Directory directory) {
                return directory.children.keySet().stream().toList();
            } else {
                return List.of(node.getName());
            }
        } else {
            return ls((Directory) parent.children.get(path[i]), i + 1, path);
        }
    }

    public void mkdir(String path) {
        mkdir(root, 1, path.split("/"));
    }

    private void mkdir(Directory parent, int i, String[] directory) {
        if (i == directory.length) {
            return;
        }
        Directory child = (Directory) parent.children.getOrDefault(directory[i], new Directory(directory[i]));
        mkdir(child, i + 1, directory);
        parent.children.put(directory[i], child);
    }

    public void addContentToFile(String filePath, String content) {
        addContentToFile(root, 1, filePath.split("/"), content);
    }

    private void addContentToFile(Directory parent, int i, String[] path, String content) {
        if (i == path.length - 1) {
            File node = (File) parent.children.getOrDefault(path[i], new File(path[i]));
            node.addContent(content);
            parent.children.put(path[i], node);
        } else {
            addContentToFile((Directory) parent.children.get(path[i]), i + 1, path, content);
        }
    }

    public String readContentFromFile(String filePath) {
        return readContentFromFile(root, 1, filePath.split("/"));
    }

    private String readContentFromFile(Directory parent, int i, String[] path) {
        if (i == path.length - 1) {
            File node = (File) parent.children.get(path[i]);
            return node.getContent();
        } else {
            return readContentFromFile((Directory) parent.children.get(path[i]), i + 1, path);
        }
    }
}
