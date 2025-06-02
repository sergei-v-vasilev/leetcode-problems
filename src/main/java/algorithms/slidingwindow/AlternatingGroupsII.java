package algorithms.slidingwindow;


/**
 * 3208. Alternating Groups II
 */
public class AlternatingGroupsII {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int result = 0;
        int violations = 0;
        for (int i = 0; i < k; i++) {
            boolean isDifferentFromPrevious = i == 0 || colors[i] != colors[i - 1];
            if (!isDifferentFromPrevious) {
                violations++;
            }
        }
        if (violations == 0) {
            result++;
        }
        int start = 0;
        int end = k - 1;
        //calculate for [start+1,end+1]
        while (start < colors.length - 1) {
            //check next end of the sliding window
            boolean newEndIsDifferentFromPrevious;
            if (end == colors.length - 1) {
                newEndIsDifferentFromPrevious = colors[end] != colors[0];
                end = 0;
            } else {
                newEndIsDifferentFromPrevious = colors[end] != colors[end + 1];
                end++;
            }
            if (!newEndIsDifferentFromPrevious) {
                violations++;
            }
            if (colors[start + 1] == colors[start]) {
                violations--;
            }
            if (violations == 0) {
                result++;
            }
            start++;
        }
        return result;
    }
}
