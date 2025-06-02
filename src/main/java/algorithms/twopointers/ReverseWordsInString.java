package algorithms.twopointers;

/**
 * 151. Reverse Words in a String
 * Time: O(n)
 * Space: O(1)
 *
 */
public class ReverseWordsInString {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder();
        int i = s.length() - 1;
        int previousBound = s.length();
        boolean isWord = false;
        while (i >= 0) {
            if (s.charAt(i) == ' ' && !isWord) {
                previousBound = i;
            } else if (s.charAt(i) == ' ' && isWord) {
                builder.append(s, i + 1, previousBound).append(" ");
                isWord = false;
                previousBound = i;
            } else {
                isWord = true;
            }
            i--;
        }
        if (isWord) {
            builder.append(s, 0, previousBound).append(" ");
        }
        return builder.toString().trim();
    }
}
