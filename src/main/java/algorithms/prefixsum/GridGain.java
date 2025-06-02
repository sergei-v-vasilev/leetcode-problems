package algorithms.prefixsum;

/**
 * 2017. Grid Game
 */
public class GridGain {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long firstRowSum = 0;
        for (int i = 0; i < n; i++) {
            firstRowSum += grid[0][i];
        }
        long secondRowSum = 0;
        long result = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            firstRowSum -= grid[0][i];
            result = Math.min(result, Math.max(firstRowSum, secondRowSum));
            secondRowSum += grid[1][i];
        }
        return result;
    }

}