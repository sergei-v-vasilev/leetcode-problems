package algorithms.graph.dfs;


/**
 * 688. Knight Probability in Chessboard
 * Time: O(n*k)
 * Space: O(n*n*k)
 * 
 */
public class KnightProbabilityInChessboard {
    public double knightProbability(int n, int k, int row, int column) {
        return knightProbability(n, k, row, column, new double[n][n][k + 1]);
    }

    private double knightProbability(int n, int k, int row, int column, double[][][] memo) {
        if (memo[row][column][k] != 0) return memo[row][column][k];
        if (k == 0) return 1.0;
        double result = 0;
        if (row + 1 < n && column + 2 < n) result += 0.125 * knightProbability(n, k - 1, row + 1, column + 2, memo);
        if (row + 2 < n && column + 1 < n) result += 0.125 * knightProbability(n, k - 1, row + 2, column + 1, memo);
        if (row - 1 >= 0 && column + 2 < n) result += 0.125 * knightProbability(n, k - 1, row - 1, column + 2, memo);
        if (row - 2 >= 0 && column + 1 < n) result += 0.125 * knightProbability(n, k - 1, row - 2, column + 1, memo);
        if (row - 1 >= 0 && column - 2 >= 0) result += 0.125 * knightProbability(n, k - 1, row - 1, column - 2, memo);
        if (row - 2 >= 0 && column - 1 >= 0) result += 0.125 * knightProbability(n, k - 1, row - 2, column - 1, memo);
        if (row + 1 < n && column - 2 >= 0) result += 0.125 * knightProbability(n, k - 1, row + 1, column - 2, memo);
        if (row + 2 < n && column - 1 >= 0) result += 0.125 * knightProbability(n, k - 1, row + 2, column - 1, memo);
        memo[row][column][k] = result;
        return result;
    }
}
