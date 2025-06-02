package algorithms.binarysearch;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes
 * Time: O(n * log(n))
 * Space: O(n)
 * 1h
 */
public class RussianDollEnvelopes {


    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (l, r) -> {
            if (l[0] == r[0]) {
                return Integer.compare(r[1], l[1]);
            } else {
                return Integer.compare(l[0], r[0]);
            }
        });
        int maxLength = 0;
        int[] d = new int[envelopes.length];
        Integer previous = null;
        for (int i = 0; i < envelopes.length; i++) {
            int j = Arrays.binarySearch(d, 0, maxLength, envelopes[i][1]);
            if (j < 0) {
                j = -(j + 1);
            }
            d[j] = envelopes[i][1];
            if (maxLength == j && (previous == null || previous != envelopes[i][0])) {
                maxLength++;
            }
            previous = envelopes[i][0];
        }
        return maxLength;
    }
}
