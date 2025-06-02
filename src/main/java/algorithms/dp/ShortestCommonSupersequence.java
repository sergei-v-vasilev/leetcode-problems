package algorithms.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 1092. Shortest Common Supersequence
 */
public class ShortestCommonSupersequence {

    private class Direction {
        final int size;
        final boolean moveOnLeft;
        final boolean moveOnRight;

        Direction(int size, boolean moveOnLeft, boolean moveOnRight) {
            this.size = size;
            this.moveOnLeft = moveOnLeft;
            this.moveOnRight = moveOnRight;
        }
    }

    public String shortestCommonSupersequenceTD(String str1, String str2) {
        Map<Integer, Map<Integer, Direction>> memo = new HashMap<>(str1.length());
        Direction root = shortestCommonSupersequence(0, 0, str1.toCharArray(), str2.toCharArray(), memo);
        int i = 0;
        int j = 0;
        int k = 0;
        char[] str1Chars = str1.toCharArray();
        char[] str2Chars = str2.toCharArray();
        char[] result = new char[root.size];
        while (k < root.size) {
            Direction direction = memo.get(i).get(j);
            if (direction.moveOnLeft) {
                result[k++] = str1Chars[i++];
                if (direction.moveOnRight) {
                    j++;
                }
            } else if (direction.moveOnRight) {
                result[k++] = str2Chars[j++];
            }
        }
        return new String(result);
    }

    private Direction shortestCommonSupersequence(int i, int j, char[] a, char[] b, Map<Integer, Map<Integer, Direction>> memo) {
        if (memo.containsKey(i) && memo.get(i).containsKey(j)) {
            return memo.get(i).get(j);
        }
        Direction direction = null;
        if (i == a.length && j == b.length) {
            direction = new Direction(0, false, false);
        } else if (i == a.length) {
            int size = shortestCommonSupersequence(i, j + 1, a, b, memo).size + 1;
            direction = new Direction(size, false, true);
        } else if (j == b.length) {
            int size = shortestCommonSupersequence(i + 1, j, a, b, memo).size + 1;
            direction = new Direction(size, true, false);
        }
        if (direction != null) {
            updateMemo(i, j, direction, memo);
            return direction;
        }
        if (a[i] == b[j]) {
            int size = shortestCommonSupersequence(i + 1, j + 1, a, b, memo).size + 1;
            direction = new Direction(size, true, true);
        } else {
            int left = shortestCommonSupersequence(i + 1, j, a, b, memo).size + 1;
            int right = shortestCommonSupersequence(i, j + 1, a, b, memo).size + 1;
            if (left < right) {
                direction = new Direction(left, true, false);
            } else {
                direction = new Direction(right, false, true);
            }
        }
        updateMemo(i, j, direction, memo);
        return direction;
    }

    private void updateMemo(int i, int j, Direction result, Map<Integer, Map<Integer, Direction>> memo) {
        Map<Integer, Direction> stringMap = memo.getOrDefault(i, new HashMap<>(1000));
        stringMap.put(j, result);
        memo.put(i, stringMap);
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        int str1Length = str1.length();
        int str2Length = str2.length();

        // Initialize the first row (when str1 is empty, the supersequence is str2's prefix)
        String[] prevRow = new String[str2Length + 1];
        for (int col = 0; col <= str2Length; col++) {
            prevRow[col] = str2.substring(0, col);
        }

        // Fill the DP table row by row
        for (int row = 1; row <= str1Length; row++) {
            // Initialize the first column (when str2 is empty, the supersequence is str1's prefix)
            String[] currRow = new String[str2Length + 1];
            currRow[0] = str1.substring(0, row);

            for (int col = 1; col <= str2Length; col++) {
                // If characters match, extend the supersequence from the diagonal value
                if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
                    currRow[col] = prevRow[col - 1] + str1.charAt(row - 1);
                } else {
                    // If characters do not match, choose the shorter supersequence
                    // From previous row (exclude current str1 char)
                    String pickS1 = prevRow[col];
                    // From previous column (exclude current str2 char)
                    String pickS2 = currRow[col - 1];

                    currRow[col] = (pickS1.length() < pickS2.length())
                            ? pickS1 + str1.charAt(row - 1)
                            : pickS2 + str2.charAt(col - 1);
                }
            }
            // Move to the next row (update previous row reference)
            prevRow = currRow;
        }

        // Return the shortest common supersequence from the last cell
        return prevRow[str2Length];
    }
}
