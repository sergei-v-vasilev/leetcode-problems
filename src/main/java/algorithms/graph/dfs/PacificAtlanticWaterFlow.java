package algorithms.graph.dfs;

import java.util.*;

/**
 * 417. Pacific Atlantic Water Flow
 * Time: O(n*m)
 * Space: O(n*m)
 *
 */
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) if (!pacific[i][0]) dfsPacific(i, 0, heights, pacific);
        for (int j = 0; j < heights[0].length; j++) if (!pacific[0][j]) dfsPacific(0, j, heights, pacific);
        List<List<Integer>> result = new LinkedList<>();
        boolean[][] flags = new boolean[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++)
            if (!flags[i][heights[0].length - 1])
                dfsAtlantic(i, heights[0].length - 1, heights, result, pacific, flags);
        for (int j = 0; j < heights[0].length; j++)
            if (!flags[heights.length - 1][j]) dfsAtlantic(heights.length - 1, j, heights, result, pacific, flags);
        return result;
    }


    private void dfsPacific(int i, int j, int[][] heights, boolean[][] points) {
        points[i][j] = true;
        if (j + 1 < heights[i].length && !points[i][j + 1] && heights[i][j] <= heights[i][j + 1]) {
            dfsPacific(i, j + 1, heights, points);
        }
        if (i + 1 < heights.length && !points[i + 1][j] && heights[i][j] <= heights[i + 1][j]) {
            dfsPacific(i + 1, j, heights, points);
        }
        if (j - 1 >= 0 && !points[i][j - 1] && heights[i][j] <= heights[i][j - 1]) {
            dfsPacific(i, j - 1, heights, points);
        }
        if (i - 1 >= 0 && !points[i - 1][j] && heights[i][j] <= heights[i - 1][j]) {
            dfsPacific(i - 1, j, heights, points);
        }

    }

    private void dfsAtlantic(int i, int j, int[][] heights, List<List<Integer>> result, boolean[][] pacific, boolean[][] points) {
        if (pacific[i][j]) {
            List<Integer> point = new ArrayList<>(2);
            point.add(i);
            point.add(j);
            result.add(point);
        }
        points[i][j] = true;
        if (j - 1 >= 0 && heights[i][j] <= heights[i][j - 1] && !points[i][j - 1]) {
            dfsAtlantic(i, j - 1, heights, result, pacific, points);
        }
        if (i - 1 >= 0 && heights[i][j] <= heights[i - 1][j] && !points[i - 1][j]) {
            dfsAtlantic(i - 1, j, heights, result, pacific, points);
        }
        if (j + 1 < heights[i].length && heights[i][j] <= heights[i][j + 1] && !points[i][j + 1]) {
            dfsAtlantic(i, j + 1, heights, result, pacific, points);
        }
        if (i + 1 < heights.length && heights[i][j] <= heights[i + 1][j] && !points[i + 1][j]) {
            dfsAtlantic(i + 1, j, heights, result, pacific, points);
        }
    }

}
