package algorithms.array;

/**
 * 58. Length of Last Word
 * Time: O(n)
 * Space: O(1)
 */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length() - 1;
        while (i >= 0) {
            if (' ' == s.charAt(i)) {
                return s.length() - i - 1;
            }
            i--;
        }
        return s.length();
    }
}
