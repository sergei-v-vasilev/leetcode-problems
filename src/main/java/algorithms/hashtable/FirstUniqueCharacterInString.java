package algorithms.hashtable;

/**
 * 387. First Unique Character in a String
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int[] letter = new int[27];
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            letter[array[i] - 'a']++;
        }
        for (int i = 0; i < array.length; i++) {
            if (letter[array[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
