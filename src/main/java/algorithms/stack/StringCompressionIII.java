package algorithms.stack;

import java.util.LinkedList;

/**
 * 3163. String Compression III
 */
public class StringCompressionIII {
    public String compressedString(String word) {
        LinkedList<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            queue.add(word.charAt(i));
        }
        int size = 0;
        while (!queue.isEmpty()) {
            char c = queue.getFirst();
            size = 0;
            while (!queue.isEmpty() && queue.getFirst() == c && size < 9) {
                queue.removeFirst();
                size++;
            }
            sb.append(Character.forDigit(size, 10));
            sb.append(c);
        }
        return sb.toString();
    }
}
