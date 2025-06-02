package algorithms.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 1718. Construct the Lexicographically Largest Valid Sequence
 */
public class ConstructLexicographicallyLargestValidSequence {

    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        constructValidSequence(n, 0, result, new HashSet<>());
        return result;
    }

    private boolean constructValidSequence(int n, int position, int[] result, Set<Integer> isUsed) {
        if (position == result.length) {
            return isUsed.size() == n;
        }
        if (result[position] != 0) {
            return constructValidSequence(n, position + 1, result, isUsed);
        }

        for (int j = n; j > 0; j--) {
            if (isUsed.contains(j)) {
                continue;
            }
            if (result[position] != 0) {
                continue;
            }
            result[position] = j;
            isUsed.add(j);
            if (j == 1) {
                if (constructValidSequence(n, position + 1, result, isUsed)) {
                    return true;
                }
            } else {
                if (position + j < result.length && result[position + j] == 0) {
                    result[position + j] = j;
                    if (constructValidSequence(n, position + 1, result, isUsed)) {
                        return true;
                    }
                }
                result[position + j] = 0;
            }

            isUsed.remove(j);
            result[position] = 0;
        }
        return false;
    }
}
