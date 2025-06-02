package algorithms.binarysearch;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1337. The K Weakest Rows in a Matrix
 *
 */
public class TheKWeakestRowsInMatrix {
    public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int count = calculateSoldiers(mat[i]);
            map.put(i, count);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (map.get(o1).compareTo(map.get(o2)) == 0) {
                return o1.compareTo(o2);
            } else return map.get(o1).compareTo(map.get(o2));
        });
        for (int i = 0; i < mat.length; i++) {
            queue.add(i);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }
        return result;
    }

    private int calculateSoldiers(int[] row) {
        int start = 0;
        int end = row.length;
        if (row[row.length - 1] == 1) return row.length;
        if (row[row.length - 1] == 0) return 0;
        while (start + 1 <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && row[mid - 1] == 1 && row[mid] == 0) {
                return mid;
            } else if (mid < row.length - 1 && row[mid] == 1 && row[mid + 1] == 0) {
                return mid + 1;
            } else if (row[mid] == 1) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return 0;
    }
}
