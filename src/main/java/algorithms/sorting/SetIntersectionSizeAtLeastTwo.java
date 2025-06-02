package algorithms.sorting;


import java.util.Arrays;

/**
 * 757. Set Intersection Size At Least Two
 */
public class SetIntersectionSizeAtLeastTwo {


    public int intersectionSizeTwo(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]); // Sort intervals: 1- end 2- start- O(nlogn)
        int[] lasts = new int[2];
        int count = 2;
        lasts[0] = intervals[0][1] - 1; // Add one before end
        lasts[1] = intervals[0][1];// Add end
        for (int i = 1; i < n; i++) { // O(n)
            int start = intervals[i][0];
            int end = intervals[i][1];
            int last = lasts[1];
            int secondLast = lasts[0];
            if (start > last) { // We need to add two fresh points
                lasts[0] = end - 1;
                lasts[1] = end;
                count+=2;
            } else if (start == last) {
                // We already added one. We need to add the end of this interval
                lasts[0] = lasts[1];
                lasts[1] = end;
                count++;
            }
            else if (start > secondLast) {
                lasts[0] = lasts[1];
                lasts[1] = end; // We already added last. We need one more
                count++;
            }
        }
        return count;
    }

}
