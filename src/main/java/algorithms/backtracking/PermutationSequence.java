package algorithms.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * 60. Permutation Sequence
 */
public class PermutationSequence {

    private int k;

    public String getPermutationRecursive(int n, int k) {
        Set<Integer> visited = new HashSet<>(n);
        this.k = k;
        return getPermutationRecursive(n, new StringBuilder(), visited);
    }

    private String getPermutationRecursive(int n, StringBuilder builder, Set<Integer> visited) {
        if (k == 1) {
            for (int i = 1; i <= n; i++) {
                if (!visited.contains(i)) {
                    builder.append(i);
                }
            }
            return builder.toString();
        }
        if (visited.size() == n) {
            k--;
            return null;
        }
        for (int i = 1; i <= n; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                builder.append(i);
                String attempt = getPermutationRecursive(n, builder, visited);
                if (attempt != null) {
                    return attempt;
                }
                builder.deleteCharAt(builder.length() - 1);
                visited.remove(i);
            }
        }
        return null;
    }

}
