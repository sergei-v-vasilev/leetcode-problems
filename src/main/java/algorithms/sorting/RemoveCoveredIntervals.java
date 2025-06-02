package algorithms.sorting;

import java.util.Arrays;

/**
 * 1288. RemoveCoveredIntervals
 */
public class RemoveCoveredIntervals {

    //[1,5], [1,4], [2,7], [5,6], [9,10]
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            else return a[0] - b[0];
        });
        int[] longestInterval = intervals[0];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] <= longestInterval[1]) {
                continue;
            }
            longestInterval = intervals[i];
            count++;
        }
        return count;
    }
}
