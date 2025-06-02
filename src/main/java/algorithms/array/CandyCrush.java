package algorithms.array;


/**
 * 723. Candy Crush
 */
public class CandyCrush {

    public int[][] candyCrush(int[][] board) {
        boolean hasCrushedCandies = true;
        while (hasCrushedCandies) {
            hasCrushedCandies = false;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    hasCrushedCandies |= markRowForCrushIfNeeded(i, j, board);
                    hasCrushedCandies |= markColumnForCrushIfNeeded(i, j, board);
                }
            }
            if (hasCrushedCandies) {
                crush(board);
                move(board);
            }
        }
        return board;
    }

    private boolean markColumnForCrushIfNeeded(int i, int j, int[][] board) {
        if (i < board.length - 2 &&
                board[i][j] != 0 &&
                Math.abs(board[i][j]) == Math.abs(board[i + 1][j]) &&
                Math.abs(board[i][j]) == Math.abs(board[i + 2][j])
        ) {
            board[i][j] = -Math.abs(board[i][j]);
            board[i + 1][j] = -Math.abs(board[i][j]);
            board[i + 2][j] = -Math.abs(board[i][j]);
            return true;
        }
        return false;
    }

    private boolean markRowForCrushIfNeeded(int i, int j, int[][] board) {
        if (j < board[0].length - 2 &&
                board[i][j] != 0 &&
                Math.abs(board[i][j]) == Math.abs(board[i][j + 1]) &&
                Math.abs(board[i][j]) == Math.abs(board[i][j + 2])
        ) {
            board[i][j] = -Math.abs(board[i][j]);
            board[i][j + 1] = -Math.abs(board[i][j]);
            board[i][j + 2] = -Math.abs(board[i][j]);
            return true;
        }
        return false;
    }

    private void crush(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] < 0) {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void move(int[][] board) {
        for (int j = 0; j < board[0].length; j++) {
            int index = board.length - 1;
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] > 0) {
                    board[index][j] = board[i][j];
                    index--;
                }
            }
            while (index >= 0) {
                board[index][j] = 0;
                index--;
            }
        }
    }


}
