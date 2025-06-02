package algorithms.backtracking;


/**
 * 741. Cherry Pickup
 */
public class CherryPickup {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        Integer[][][][] memo = new Integer[n][n][n][n];
        return Math.max(cherryPickup(0, 0, 0, 0, memo, grid), 0);
    }

    private int cherryPickup(int i1, int j1, int i2, int j2, Integer[][][][] memo, int[][] grid) {
        int n = memo.length;
        if (i1 == n || j1 == n || i2 == n || j2 == n) {
            return Integer.MIN_VALUE;
        }
        if (grid[i1][j1] == -1 || grid[i2][j2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (memo[i1][j1][i2][j2] != null) {
            return memo[i1][j1][i2][j2];
        }

        if (i1 == n - 1 && j1 == n - 1 || i2 == n - 1 && j2 == n - 1) {
            return grid[n - 1][n - 1];
        }

        int cherries = i1 == i2 && j1 == j2 ? grid[i1][j1] : grid[i1][j1] + grid[i2][j2];

        cherries += Math.max(
                Math.max(cherryPickup(i1 + 1, j1, i2 + 1, j2, memo, grid), cherryPickup(i1, j1 + 1, i2 + 1, j2, memo, grid)),
                Math.max(cherryPickup(i1 + 1, j1, i2, j2 + 1, memo, grid), cherryPickup(i1, j1 + 1, i2, j2 + 1, memo, grid))
        );

        memo[i1][j1][i2][j2] = cherries;
        return cherries;
    }
}
