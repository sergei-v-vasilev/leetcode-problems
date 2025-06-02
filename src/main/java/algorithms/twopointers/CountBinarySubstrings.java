package algorithms.twopointers;

/**
 * 696. Count Binary Substrings
 * Time: O(n)
 * Space: O(1)
 *
 */
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int result = 0;
        int first = 0;
        int second = 0;
        boolean isOne = s.charAt(0) == '1';
        int i = 0;
        while (i < s.length() && (isOne && s.charAt(i) == '1' || !isOne && s.charAt(i) == '0')) {
            first++;
            i++;
        }
        isOne = !isOne;
        while (i < s.length()) {
            while (i < s.length() && (isOne && s.charAt(i) == '1' || !isOne && s.charAt(i) == '0')) {
                second++;
                i++;
            }
            result += Math.min(first, second);
            first = second;
            second = 0;
            isOne = !isOne;
        }
        return result;
    }
}
