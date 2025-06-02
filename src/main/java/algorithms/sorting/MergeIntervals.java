package algorithms.sorting;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56. Merge Intervals
 * Time: O(n * log(n))
 * Space: O(1)
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(left -> left[0]));
        int size = 1;
        int maxRight = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == intervals[i - 1][0]) {
                maxRight = Math.max(maxRight, intervals[i][1]);
            } else {
                if (intervals[i][0] <= intervals[i - 1][1]) {
                    intervals[i][0] = intervals[i - 1][0];
                    maxRight = Math.max(maxRight, intervals[i][1]);
                } else {
                    size++;
                    maxRight = intervals[i][1];
                }
            }
            intervals[i][1] = maxRight;
        }
        int[][] result = new int[size][2];
        Integer currentLeft = null;
        int j = 0;
        for (int i = intervals.length - 1; i >= 0; i--) {
            if (currentLeft == null || currentLeft != intervals[i][0]) {
                result[j][0] = intervals[i][0];
                result[j][1] = intervals[i][1];
                currentLeft = intervals[i][0];
                j++;
            }
        }
        return result;
    }
}
