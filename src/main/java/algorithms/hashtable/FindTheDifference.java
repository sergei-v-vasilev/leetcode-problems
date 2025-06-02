package algorithms.hashtable;

/**
 * 389. Find the Difference
 * Time: O(n)
 * Space: O(1)
 * <p>
 * 
 */
public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] dictionary = new int[27];
        for (int i = 0; i < s.length(); i++) {
            dictionary[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (dictionary[t.charAt(i) - 'a'] == 0) {
                return t.charAt(i);
            } else {
                dictionary[t.charAt(i) - 'a']--;
            }
        }
        return '0';
    }
}
