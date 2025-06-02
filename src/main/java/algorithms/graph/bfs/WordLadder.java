package algorithms.graph.bfs;

import java.util.*;

/**
 * 127. Word Ladder
 * Time: O(n*l)
 * Space: O(n)
 * 
 */
public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        if (!dictionary.contains(endWord)) {
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int size;
        int ladderLength = 1;
        String currentWord;
        String tempString;
        char[] array;
        char temp;
        while (!queue.isEmpty() && !dictionary.isEmpty()) {
            size = queue.size();
            while (size > 0 && !queue.isEmpty()) {
                currentWord = queue.pollFirst();
                array = currentWord.toCharArray();
                size--;
                if (isTransformable(currentWord, endWord)) { //O(l)
                    return ladderLength + 1;
                }
                for (int i = 0; i < currentWord.length(); i++) { //O(l)
                    temp = array[i];
                    for (char c = 'a'; c <= 'z'; c++) { //O(1)
                        array[i] = c;
                        tempString = new String(array);
                        if (dictionary.contains(tempString) && !visited.contains(tempString)) { //O(1)
                            queue.add(tempString);
                            visited.add(tempString);
                        }
                    }
                    array[i] = temp;
                }
            }
            ladderLength++;
        }
        return 0;
    }

    /**
     * Time: O(l)
     * Space: O(1)
     */
    private boolean isTransformable(String word, String transformedWord) {
        boolean hasDifference = false;
        int pointer = 0;
        while (pointer < word.length()) {
            if (!hasDifference && word.charAt(pointer) != transformedWord.charAt(pointer)) {
                hasDifference = true;
            } else if (word.charAt(pointer) != transformedWord.charAt(pointer)) {
                return false;
            }
            pointer++;
        }
        return true;
    }
}
