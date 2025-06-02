package algorithms.graph.dijkstra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2290. Minimum Obstacle Removal to Reach Corner
 */
public class MinimalObstacleRemovalToReachCorner {

    public int minimumObstacles(int[][] grid) {
        int[][] distance = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[0][0] = 0;
        //[row,column, number of removed before]
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> distance[a[0]][a[1]]));
        queue.add(new int[]{0, 0});
        int i, j, numberOfRemovedBefore;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            i = current[0];
            j = current[1];
            numberOfRemovedBefore = distance[i][j];
            if (i == grid.length - 1 && j == grid[0].length - 1) {
                return distance[i][j];
            }
            if (grid[i][j] == 1) {
                numberOfRemovedBefore++;
            }
            if (i > 0 && distance[i - 1][j] > numberOfRemovedBefore) {
                distance[i - 1][j] = numberOfRemovedBefore;
                queue.add(new int[]{i - 1, j});
            }
            //left
            if (j > 0 && distance[i][j - 1] > numberOfRemovedBefore) {
                distance[i][j - 1] = numberOfRemovedBefore;
                queue.add(new int[]{i, j - 1, numberOfRemovedBefore});
            }
            //down
            if (i < grid.length - 1 && distance[i + 1][j] > numberOfRemovedBefore) {
                distance[i + 1][j] = numberOfRemovedBefore;
                queue.add(new int[]{i + 1, j, numberOfRemovedBefore});
            }
            //right
            if (j < grid[0].length - 1 && distance[i][j + 1] > numberOfRemovedBefore) {
                distance[i][j + 1] = numberOfRemovedBefore;
                queue.add(new int[]{i, j + 1, numberOfRemovedBefore});
            }
        }
        throw new RuntimeException("");
    }
}
