package algorithms.graph.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 212. Word Search II
 * Time: O(n^2n)
 * Space: O(n)
 */
public class WordSearchII {

    public class TrieNode {
        Map<Character, TrieNode> children;
        StringBuilder builder;
        boolean isWord;

        public TrieNode(boolean isWord) {
            children = new HashMap<>();
            this.isWord = isWord;
            builder = new StringBuilder();
        }

        public void insert(char[] letters, int start) {
            if (start >= letters.length) {
                return;
            }
            if (children.containsKey(letters[start])) {
                if (!children.get(letters[start]).isWord) {
                    children.get(letters[start]).isWord = start == letters.length - 1;
                }
                children.get(letters[start]).insert(letters, start + 1);
            } else {
                TrieNode node = new TrieNode(start == letters.length - 1);
                node.builder.append(new String(letters, 0, start + 1));
                children.put(letters[start], node);
                node.insert(letters, start + 1);
            }
        }

        public boolean exist(char[] letters, int start) {
            if (start >= letters.length) {
                return false;
            }
            if (start == letters.length - 1 && children.containsKey(letters[start])) {
                return children.get(letters[start]).isWord;
            } else if (children.containsKey(letters[start])) {
                return children.get(letters[start]).exist(letters, start + 1);
            }
            return false;
        }
    }

    public void findWord(int i, int j, char[][] board, TrieNode root, List<String> result) {
        if (board[i][j] == '1') {
            return;
        }
        if (!root.children.containsKey(board[i][j])) {
            return;
        }
        if (root.children.get(board[i][j]).isWord && !result.contains(root.children.get(board[i][j]).builder.toString())) {
            result.add(root.children.get(board[i][j]).builder.toString());
        }
        char c = board[i][j];
        board[i][j] = '1';
        if (i > 0) {
            findWord(i - 1, j, board, root.children.get(c), result);
        }
        if (j > 0) {
            findWord(i, j - 1, board, root.children.get(c), result);
        }
        if (i < board.length - 1) {
            findWord(i + 1, j, board, root.children.get(c), result);
        }
        if (j < board[i].length - 1) {
            findWord(i, j + 1, board, root.children.get(c), result);
        }
        board[i][j] = c;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode(false);
        for (String word : words) {
            root.insert(word.toCharArray(), 0);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    findWord(i, j, board, root, result);
                }
            }
        }


        return result;
    }
}
