package algorithms.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 51. N-Queens
 * Time: O(n ^ 5), n ==9
 * Space: O(n ^ 3)
 *
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new LinkedList<>();
        solveNQueens(0, n, n, new int[n][n], result);
        return result;
    }

    private void solveNQueens(int r, int queens, int n, int[][] board, List<List<String>> result) {
        if (queens == 0) {
            result.add(createBoard(board));
            return;
        }
        for (int i = r; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    solveNQueens(i, queens - 1, n, handleQueen(i, j, board), result);
                }
            }
        }
    }

    private int[][] handleQueen(int i, int j, int[][] old) {
        int[][] board = new int[old.length][old.length];
        for (int k = 0; k < board.length; k++) {
            for (int s = 0; s < board.length; s++) {
                board[k][s] = old[k][s];
            }
        }
        board[i][j] = 2;
        for (int k = 0; k < board.length; k++) {
            if (k != i) {
                board[k][j] = 1;
            }
        }
        for (int k = 0; k < board.length; k++) {
            if (k != j) {
                board[i][k] = 1;
            }
        }
        for (int k = 1; i + k < board.length && j + k < board.length; k++) {
            board[i + k][j + k] = 1;
        }
        for (int k = 1; i - k >= 0 && j - k >= 0; k++) {
            board[i - k][j - k] = 1;
        }
        for (int k = 1; i + k < board.length && j - k >= 0; k++) {
            board[i + k][j - k] = 1;
        }
        for (int k = 1; j + k < board.length && i - k >= 0; k++) {
            board[i - k][j + k] = 1;
        }
        return board;
    }

    private static List<String> createBoard(int[][] board) {
        List<String> result = new ArrayList<>(board.length);
        StringBuilder builder;
        for (int i = 0; i < board.length; i++) {
            builder = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 2) {
                    builder.append("Q");
                } else {
                    builder.append(".");
                }
            }
            result.add(builder.toString());
        }
        return result;
    }
}
