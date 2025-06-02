package algorithms.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 957. Prison Cells After N Days
 * Time: O(k+ n / k), k - k is the length of max cycle
 * Space: O(n)
 *
 */
public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> map = new HashMap<>();
        StringBuilder builder;
        int previous;
        int temp;
        boolean foundTheCycle = false;
        while (n > 0) {
            if (!foundTheCycle) {
                builder = new StringBuilder();
                for (int k = 0; k < cells.length; k++) {
                    builder.append(cells[k]);
                }
                if (map.containsKey(builder.toString())) {
                    int step = n - map.get(builder.toString());
                    n = n % step;
                    foundTheCycle = true;
                } else {
                    map.put(builder.toString(), n);
                }
            }
            if (n == 0) return cells;
            previous = cells[0];
            for (int k = 1; k < cells.length - 1; k++) {
                temp = cells[k];
                if (previous == 0 && cells[k + 1] == 0) {
                    cells[k] = 1;
                } else if (previous == 1 && cells[k + 1] == 1) {
                    cells[k] = 1;
                } else {
                    cells[k] = 0;
                }
                previous = temp;
            }
            cells[0] = 0;
            cells[cells.length - 1] = 0;
            n--;
        }
        return cells;
    }
}
