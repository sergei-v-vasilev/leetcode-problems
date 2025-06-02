package algorithms.graph.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2577. Minimum Time to Visit a Cell In a Grid
 *
 */
public class MinimumTimeToVisitACellInGrid {
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) {
            return -1;
        }
        int[][] time = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(time[i], Integer.MAX_VALUE);
        }
        time[0][0] = 0;
        //[row,column, number of removed before]
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> time[a[0]][a[1]]));
        queue.add(new int[]{0, 0});
        int i, j, now;
        boolean isOdd = false;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            i = current[0];
            j = current[1];
            now = time[i][j] + 1;

            //up
            if (i > 0 && time[i - 1][j] > now && grid[i - 1][j] <= now) {
                time[i - 1][j] = now;
                queue.add(new int[]{i - 1, j});
            } else if (i > 0 && grid[i - 1][j] > now) {
                int wait = ((grid[i - 1][j] - now + 1) / 2) * 2;
                if (time[i - 1][j] > now + wait) {
                    time[i - 1][j] = now + wait;
                    queue.add(new int[]{i - 1, j});
                }
            }
            //left
            if (j > 0 && time[i][j - 1] > now && grid[i][j - 1] <= now) {
                time[i][j - 1] = now;
                queue.add(new int[]{i, j - 1});
            } else if (j > 0 && grid[i][j - 1] > now) {
                int wait = ((grid[i][j - 1] - now + 1) / 2) * 2;
                if (time[i][j - 1] > now + wait) {
                    time[i][j - 1] = now + wait;
                    queue.add(new int[]{i, j - 1});
                }
            }
            //down
            if (i < grid.length - 1 && time[i + 1][j] > now && grid[i + 1][j] <= now) {
                time[i + 1][j] = now;
                queue.add(new int[]{i + 1, j});
            } else if (i < grid.length - 1 && grid[i + 1][j] > now) {
                int wait = ((grid[i + 1][j] - now + 1) / 2) * 2;
                if (time[i + 1][j] > now + wait) {
                    time[i + 1][j] = now + wait;
                    queue.add(new int[]{i + 1, j});
                }
            }
            //right
            if (j < grid[0].length - 1 && time[i][j + 1] > now && grid[i][j + 1] <= now) {
                time[i][j + 1] = now;
                queue.add(new int[]{i, j + 1});
            } else if (j < grid[0].length - 1 && grid[i][j + 1] > now) {
                int wait = ((grid[i][j + 1] - now + 1) / 2) * 2;
                if (time[i][j + 1] > now + wait) {
                    time[i][j + 1] = now + wait;
                    queue.add(new int[]{i, j + 1});
                }
            }
        }
        return time[grid.length - 1][grid[0].length - 1];
    }
}
