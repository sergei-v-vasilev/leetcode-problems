package algorithms.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 967. Numbers With Same Consecutive Differences
 *
 */
public class NumbersWithSameConsecutiveDifferences {

    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> result = new HashSet<>();
        for (int i = 1; i < 10; i++) {
            StringBuilder builder = new StringBuilder();
            builder.append(i);
            numsSameConsecDiff(i, n - 1, k, result, builder);
        }
        int[] r = new int[result.size()];
        int i = 0;
        for (int value : result) {
            r[i] = value;
            i++;
        }
        return r;
    }

    private void numsSameConsecDiff(int previous, int n, int k, Set<Integer> result, StringBuilder value) {
        if (n == 0) {
            result.add(Integer.parseInt(value.toString()));
            return;
        }
        int number;
        if (previous + k < 10) {
            number = previous + k;
            value.append(number);
            numsSameConsecDiff(number, n - 1, k, result, value);
            value.deleteCharAt(value.length() - 1);
        }
        if (previous - k >= 0) {
            number = previous - k;
            value.append(number);
            numsSameConsecDiff(number, n - 1, k, result, value);
            value.deleteCharAt(value.length() - 1);
        }
    }
}
