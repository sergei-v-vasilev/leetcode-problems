package algorithms.twopointers;

/**
 * 1910. Remove All Occurrences of a Substring
 */
public class RemoveAllOccurrencesOfSubstring {

    public String removeOccurrences(String s, String part) {
        StringBuilder result = new StringBuilder();
        int pointer = 0;
        for (int i = 0; i < s.length(); i++) {
            result.append(s.charAt(i));
            if (pointer >= part.length() - 1) {
                String substring = result.substring(pointer - part.length() + 1, pointer + 1);
                if (substring.equals(part)) {
                    result.delete(pointer - part.length() + 1, pointer + 1);
                    pointer -= part.length();
                }
            }
            pointer++;
        }
        return result.toString();
    }
}
