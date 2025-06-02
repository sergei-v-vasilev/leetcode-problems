package algorithms.heap;

import java.util.*;

/**
 * 1368. Minimum Cost to Make at Least One Valid Path in a Grid
 * 1h
 */
public class MinimumCostToMakeAtLeastOneValidPath {


    public int minCost(int[][] grid) {
        int[][] counters = new int[grid.length][grid[0].length];
        Arrays.stream(counters).forEach(row -> Arrays.fill(row, Integer.MAX_VALUE));
        counters[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> counters[o[0]][o[1]]));
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] indices = pq.poll();
            int i = indices[0];
            int j = indices[1];
            if (j < grid[0].length - 1) {
                int cost = grid[i][j] == 1 ? counters[i][j] : counters[i][j] + 1;
                if (counters[i][j + 1] > cost) {
                    counters[i][j + 1] = cost;
                    pq.offer(new int[]{i, j + 1});
                }
            }
            if (j > 0) {
                int cost = grid[i][j] == 2 ? counters[i][j] : counters[i][j] + 1;
                if (counters[i][j - 1] > cost) {
                    counters[i][j - 1] = cost;
                    pq.offer(new int[]{i, j - 1});
                }
            }
            if (i < grid.length - 1) {
                int cost = grid[i][j] == 3 ? counters[i][j] : counters[i][j] + 1;
                if (counters[i + 1][j] > cost) {
                    counters[i + 1][j] = cost;
                    pq.offer(new int[]{i + 1, j});
                }
            }
            if (i > 0) {
                int cost = grid[i][j] == 4 ? counters[i][j] : counters[i][j] + 1;
                if (counters[i - 1][j] > cost) {
                    counters[i - 1][j] = cost;
                    pq.offer(new int[]{i - 1, j});
                }
            }
        }
        return counters[grid.length - 1][grid[0].length - 1];
    }

}
