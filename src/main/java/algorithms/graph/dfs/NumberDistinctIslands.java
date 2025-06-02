package algorithms.graph.dfs;

import java.util.HashSet;
import java.util.Set;

/**
 * 694. Number of Distinct Islands
 */
public class NumberDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        Set<String> islands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder builder = new StringBuilder();
                    builder = sinkTheIsland(i, j, grid, builder, 'S');
                    String island = builder.toString();
                    islands.add(island);
                }
            }
        }
        return islands.size();
    }

    private StringBuilder sinkTheIsland(int i, int j, int[][] grid, StringBuilder builder, char direction) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
            return builder;
        }
        if (grid[i][j] == 0) {
            return builder;
        }
        grid[i][j] = 0;
        builder.append(direction);
        //up
        builder = sinkTheIsland(i - 1, j, grid, builder, 'U');
        //right
        builder = sinkTheIsland(i, j + 1, grid, builder, 'R');
        //down
        builder = sinkTheIsland(i + 1, j, grid, builder, 'D');
        //left
        builder = sinkTheIsland(i, j - 1, grid, builder, 'L');
        builder.append("E");
        return builder;
    }
}
