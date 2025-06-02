package algorithms.greedy;

/**
 * 807. Max Increase to Keep City Skyline
 * Time: O(n * n)
 * Space: O(n)
 *
 */
public class MaxIncreaseToKeepCitySkyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int n = grid.length;
        int[] rowMax = new int[n];
        int[] columnMax = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowMax[i] = Math.max(rowMax[i], grid[i][j]);
                columnMax[j] = Math.max(columnMax[j], grid[i][j]);
            }
        }
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                totalSum += Math.min(rowMax[i], columnMax[j]) - grid[i][j];
            }
        }
        return totalSum;
    }
}
