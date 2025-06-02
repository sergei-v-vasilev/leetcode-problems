package algorithms.graph.dfs;

/**
 * 1020. Number of Enclaves
 * Time: O(n*m)
 * Space: O(1)
 * 
 */
public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            sinkTheLand(i, 0, grid);
            sinkTheLand(i, grid[i].length - 1, grid);
        }
        for (int j = 0; j < grid[0].length; j++) {
            sinkTheLand(0, j, grid);
            sinkTheLand(grid.length - 1, j, grid);
        }
        int numberOfLands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    numberOfLands += sinkTheLand(i, j, grid);
                }
            }
        }
        return numberOfLands;
    }

    private int sinkTheLand(int i, int j, int[][] grid) {
        int area = 0;
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            area++;
            if (j > 0) {
                area += sinkTheLand(i, j - 1, grid);
            }
            if (i > 0) {
                area += sinkTheLand(i - 1, j, grid);
            }
            if (j < grid[i].length - 1) {
                area += sinkTheLand(i, j + 1, grid);
            }
            if (i < grid.length - 1) {
                area += sinkTheLand(i + 1, j, grid);
            }
        }
        return area;
    }
}
