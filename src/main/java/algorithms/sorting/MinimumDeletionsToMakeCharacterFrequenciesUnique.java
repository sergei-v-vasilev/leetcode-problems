package algorithms.sorting;

import java.util.Arrays;

/**
 * 1647. Minimum Deletions to Make Character Frequencies Unique
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class MinimumDeletionsToMakeCharacterFrequenciesUnique {

    public int minDeletions(String s) {
        int[] frequency = new int[27];
        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }
        Arrays.sort(frequency);
        int numberOfOperators = 0;
        int last = frequency[frequency.length - 1];
        for (int i = frequency.length - 2; i >= 0 && frequency[i] > 0; i--) {
            if (last > frequency[i]) {
                last = frequency[i];
            } else if (last <= frequency[i]) {
                numberOfOperators += last > 0 ? frequency[i] - last + 1 : frequency[i];
                last = last - 1;
            }
        }
        return numberOfOperators;
    }

}
