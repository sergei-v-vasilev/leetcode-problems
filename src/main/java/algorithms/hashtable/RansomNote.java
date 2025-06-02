package algorithms.hashtable;

/**
 * 383. Ransom Note
 * Time: O(n)
 * Space: O(n)
 *
 */
public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] counters = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            counters[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (counters[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            }
            counters[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }
}
