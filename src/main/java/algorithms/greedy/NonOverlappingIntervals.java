package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 435. Non-overlapping Intervals
 * Time: O(n * log(n))
 * Space: O(1)
 * 
 */
public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(left -> left[0]));
        int lastEnd = intervals[0][1];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                lastEnd = Math.min(lastEnd, intervals[i][1]);
                count++;
            } else {
                lastEnd = intervals[i][1];
            }
        }
        return count;
    }
}
