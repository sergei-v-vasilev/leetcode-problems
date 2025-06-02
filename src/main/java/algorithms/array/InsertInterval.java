package algorithms.array;

/**
 * 57. Insert Interval
 * Time: O(n)
 * Space: O(1)
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        if (n == 0) return new int[][]{newInterval};
        if (newInterval[1] < intervals[0][0]) {
            int[][] result = new int[n + 1][2];
            result[0] = newInterval;
            System.arraycopy(intervals, 0, result, 1, n);
            return result;
        }
        if (intervals[intervals.length - 1][1] < newInterval[0]) {
            int[][] result = new int[n + 1][2];
            result[n] = newInterval;
            System.arraycopy(intervals, 0, result, 0, n);
            return result;
        }
        int i = 0;
        while (i < n && !isOverlaps(intervals[i], newInterval) && intervals[i][1] < newInterval[0]) i++;
        int j = i;
        if (isOverlaps(intervals[j], newInterval)) {
            while (j < n && isOverlaps(intervals[j], newInterval)) {
                intervals[j][0] = Math.min(intervals[j][0], newInterval[0]);
                intervals[j][1] = Math.max(intervals[j][1], newInterval[1]);
                newInterval = intervals[j];
                j++;
            }
            int[][] result = new int[i + (n - j) + 1][2];
            System.arraycopy(intervals, 0, result, 0, i);
            result[i] = newInterval;
            System.arraycopy(intervals, j, result, i + 1, n - j);
            return result;
        } else {
            int[][] result = new int[n + 1][2];
            System.arraycopy(intervals, 0, result, 0, i);
            result[i] = newInterval;
            System.arraycopy(intervals, i, result, i + 1, n - i);
            return result;
        }
    }

    private boolean isOverlaps(int[] l, int[] r) {
        if (l[0] <= r[0] && r[0] <= l[1]) return true;
        if (l[0] <= r[1] && r[1] <= l[1]) return true;
        if (r[0] <= l[0] && l[0] <= r[1]) return true;
        if (r[0] <= l[1] && l[1] <= r[1]) return true;
        return false;
    }

}
