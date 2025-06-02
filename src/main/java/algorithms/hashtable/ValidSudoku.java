package algorithms.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Time: O(1) because of the constraint 9
 * Space: O(1) because of the constraint 9
 * 
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> firstSubBox = new HashSet<>();
        Set<Character> secondSubBox = new HashSet<>();
        Set<Character> thirdSubBox = new HashSet<>();
        Set<Character> row = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            row.clear();
            if (i == 3 || i == 6) {
                firstSubBox.clear();
                secondSubBox.clear();
                thirdSubBox.clear();
            }
            for (int j = 0; j < board.length; j++) {
                if (!Character.isDigit(board[i][j])) {
                    continue;
                }
                if (row.contains(board[i][j])) {
                    return false;
                }
                row.add(board[i][j]);
                if (j / 3 == 0) {
                    if (firstSubBox.contains(board[i][j])) {
                        return false;
                    }
                    firstSubBox.add(board[i][j]);
                } else if (j / 3 == 1) {
                    if (secondSubBox.contains(board[i][j])) {
                        return false;
                    }
                    secondSubBox.add(board[i][j]);
                } else if (j / 3 == 2) {
                    if (thirdSubBox.contains(board[i][j])) {
                        return false;
                    }
                    thirdSubBox.add(board[i][j]);
                }
            }
        }
        for (int j = 0; j < board.length; j++) {
            row.clear();
            for (int i = 0; i < board.length; i++) {
                if (!Character.isDigit(board[i][j])) {
                    continue;
                }
                if (row.contains(board[i][j])) {
                    return false;
                }
                row.add(board[i][j]);
            }
        }
        return true;
    }
}
