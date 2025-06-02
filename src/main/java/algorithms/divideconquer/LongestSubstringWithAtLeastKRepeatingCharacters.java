package algorithms.divideconquer;


/**
 * 395. Longest Substring with At Least K Repeating Characters
 * Time: O(n^2)
 * Space: O(n)
 * 
 */
public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        return longestSubstring(0, s.length(), s, k);
    }

    private int longestSubstring(int start, int end, String s, int k) {
        int[] counts = new int[26];
        for (int i = start; i < end; i++) {
            counts[s.charAt(i) - 'a']++;
        }
        for (int i = start; i < end; i++) {
            if (counts[s.charAt(i) - 'a'] < k) {
                int index = i + 1;
                while (index < end && s.charAt(index - 1) == s.charAt(index)) {
                    index++;
                }
                // divide and conquer: if counts[s.charAt(index) - 'a'] < k then it cannot be in result substring,
                // and we can check left and right parts of original string
                return Math.max(longestSubstring(start, i, s, k), longestSubstring(index, end, s, k));
            }
        }
        return end - start;
    }
}
