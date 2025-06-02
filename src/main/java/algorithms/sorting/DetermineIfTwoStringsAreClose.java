package algorithms.sorting;

import java.util.Arrays;

/**
 * 1657. Determine if Two Strings Are Close
 */
public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] counts1 = new int[26];
        int[] counts2 = new int[26];
        for (int i = 0; i < word1.length(); i++) {
            counts1[word1.charAt(i) - 'a']++;
            counts2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (counts1[i] != 0 && counts2[i] == 0) return false;
            if (counts2[i] != 0 && counts1[i] == 0) return false;
        }
        Arrays.sort(counts1);
        Arrays.sort(counts2);
        for (int i = 0; i < 26; i++) {
            if (counts1[i] != counts2[i]) return false;
        }
        return true;
    }

}
