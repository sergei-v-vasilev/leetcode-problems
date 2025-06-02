package algorithms.graph.dfs;

/**
 * 1905. Count Sub Islands
 * Time: O(n*m)
 * Space: O(1)
 * 
 */
public class CountSubIslands {
    public int countSubIslands(int[][] template, int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (sinkTheIsland(i, j, grid, template)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean sinkTheIsland(int i, int j, int[][] grid, int[][] template) {
        boolean isSubIsland = true;
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            isSubIsland = template[i][j] == 1;
            if (i > 0) {
                isSubIsland = sinkTheIsland(i - 1, j, grid, template) && isSubIsland;
            }
            if (i < grid.length - 1) {
                isSubIsland = sinkTheIsland(i + 1, j, grid, template) && isSubIsland;
            }
            if (j > 0) {
                isSubIsland = sinkTheIsland(i, j - 1, grid, template) && isSubIsland;
            }
            if (j < grid[i].length - 1) {
                isSubIsland = sinkTheIsland(i, j + 1, grid, template) && isSubIsland;
            }
        }
        return isSubIsland;
    }
}
