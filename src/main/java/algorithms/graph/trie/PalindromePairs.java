package algorithms.graph.trie;


import java.util.*;

/**
 * 336. Palindrome Pairs
 * 
 */
public class PalindromePairs {

    private class Trie {
        private final Map<Character, Trie> children;
        private boolean isWord = false;
        private int indexInArray;

        Trie() {
            children = new HashMap<>();
        }

        public void insertReverseWord(String word, int indexInArray) {
            insertReverseWord(word.length() - 1, word.toCharArray(), indexInArray);
        }

        private void insertReverseWord(int index, char[] word, int indexInArray) {
            if (index >= 0) {
                char letter = word[index];
                Trie child = children.getOrDefault(letter, new Trie());
                if (index == 0) {
                    child.isWord = true;
                    child.indexInArray = indexInArray;
                }
                child.insertReverseWord(index - 1, word, indexInArray);
                children.put(letter, child);
            }
        }

        public List<Integer> searchPalindromes(String word) {
            List<Integer> indices = new LinkedList<>();
            return searchPalindromes(0, word.toCharArray(), indices);
        }

        private List<Integer> searchPalindromes(int index, char[] word, List<Integer> indices) {
            if (index == word.length) {
                indices.addAll(findAllPalindromes(new StringBuilder(), new LinkedList<>()));
                if (isWord) {
                    indices.add(indexInArray);
                }
                return indices;
            } else if (children.containsKey(word[index])) {
                if (isWord) {
                    String leftPartOfWord = new String(word, index, word.length - index);
                    if (leftPartOfWord.equals(new StringBuilder(leftPartOfWord).reverse().toString())) {
                        indices.add(indexInArray);
                    }
                }
                return children.get(word[index]).searchPalindromes(index + 1, word, indices);
            } else if (isWord) {
                String leftPartOfWord = new String(word, index, word.length - index);
                if (isPalindrome(leftPartOfWord)) {
                    indices.add(indexInArray);
                }
                return indices;
            } else {
                return indices;
            }
        }

        private List<Integer> findAllPalindromes(StringBuilder builder, List<Integer> palindromes) {
            if (isWord) {
                if (builder.length() > 0 && isPalindrome(builder.toString())) {
                    palindromes.add(indexInArray);
                }
            }
            for (char letter : children.keySet()) {
                builder.append(letter);
                palindromes = children.get(letter).findAllPalindromes(builder, palindromes);
                builder.deleteCharAt(builder.length() - 1);
            }
            return palindromes;
        }

        private boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }

    public List<List<Integer>> palindromePairs(String[] words) {
        Trie root = new Trie();
        int empty = -1;
        for (int i = 0; i < words.length; i++) {
            root.insertReverseWord(words[i], i);
            if (words[i].length() == 0) {
                empty = i;
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            List<Integer> palindromes = root.searchPalindromes(words[i]);
            for (Integer index : palindromes) {
                if (index != i) {
                    List<Integer> indices = new ArrayList<>(2);
                    indices.add(i);
                    indices.add(index);
                    result.add(indices);
                } else if (empty != -1) {
                    List<Integer> indices = new ArrayList<>(2);
                    indices.add(i);
                    indices.add(empty);
                    result.add(indices);
                }
            }
        }
        return result;
    }

}
