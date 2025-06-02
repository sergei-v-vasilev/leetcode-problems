package algorithms.binarysearch;

import java.util.Arrays;

/**
 * 744. Find Smallest Letter Greater Than Target
 *
 */
public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        if (target == 'z') return letters[0];
        int index = Arrays.binarySearch(letters, target);
        if (index < 0) {
            index = -(index + 1);
        }
        while (index < letters.length && letters[index] == target) {
            index++;
        }
        if (index < letters.length) {
            return letters[index];
        } else {
            return letters[0];
        }
    }
}
