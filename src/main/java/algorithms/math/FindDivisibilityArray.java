package algorithms.math;


/**
 * 2575. Find the Divisibility Array of a String
 */
public class FindDivisibilityArray {
    public int[] divisibilityArray(String word, int m) {
        int[] divisibilityArray = new int[word.length()];
        long number = 0;
        for (int i = 0; i < word.length(); i++) {
            number = number * 10 + (word.charAt(i) - '0');
            divisibilityArray[i] = number % m == 0 ? 1 : 0;
            number %= m;
        }
        return divisibilityArray;
    }
}
