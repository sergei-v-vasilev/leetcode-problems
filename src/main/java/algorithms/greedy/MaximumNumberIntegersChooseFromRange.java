package algorithms.greedy;

import java.util.HashSet;
import java.util.Set;

/**
 * 2554. Maximum Number of Integers to Choose From a Range I
 */
public class MaximumNumberIntegersChooseFromRange {

    public int maxCount(int[] banned, int n, int maxSum) {
        int counter = 0;
        int sum = 0;
        Set<Integer> bannedSet = new HashSet<>();
        for (int j : banned) {
            bannedSet.add(j);
        }
        for (int i = 1; i <= n; i++) {
            if (!bannedSet.contains(i)) {
                sum += i;
                if (sum <= maxSum) {
                    counter++;
                } else return counter;
            }
        }
        return counter;
    }
}
