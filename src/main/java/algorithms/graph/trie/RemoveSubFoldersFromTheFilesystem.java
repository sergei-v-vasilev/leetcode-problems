package algorithms.graph.trie;

import java.util.*;

/**
 * 1233. Remove Sub-Folders from the Filesystem
 */
public class RemoveSubFoldersFromTheFilesystem {

    private class TrieNode {
        String folder;
        boolean isMentioned;
        final Map<String, TrieNode> children;

        public TrieNode(String folder) {
            this.folder = folder;
            children = new HashMap<>();
            this.isMentioned = false;
        }

        public void addFolders(int i, String[] folders) {
            String folder = folders[i];
            TrieNode node = children.getOrDefault(folder, new TrieNode(folder));
            if (i < folders.length - 1) {
                node.addFolders(i + 1, folders);
            }
            if (!node.isMentioned && i == folders.length - 1) {
                node.isMentioned = true;
            }
            children.put(folder, node);
        }

        public boolean isSubfolder(int i, String[] folders) {
            String folder = folders[i];
            TrieNode node = children.getOrDefault(folder, new TrieNode(folder));
            boolean isSubfolder = false;
            if (i < folders.length - 1) {
                if (node.isMentioned) {
                    return true;
                }
                isSubfolder = node.isSubfolder(i + 1, folders);
            }
            children.put(folder, node);
            return isSubfolder;
        }
    }

    public List<String> removeSubfolders(String[] folder) {
        TrieNode root = new TrieNode("");
        List<String> result = new LinkedList<>();
        for (String s : folder) {
            root.addFolders(1, s.split("/"));
        }
        for (String s : folder) {
            if (!root.isSubfolder(1, s.split("/"))) {
                result.add(s);
            }
        }
        return result;
    }
}
