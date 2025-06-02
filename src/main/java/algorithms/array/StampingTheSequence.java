package algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 936. Stamping The Sequence
 */
public class StampingTheSequence {

    public int[] movesToStamp(String stamp, String target) {
        char[] stampArray = stamp.toCharArray();
        char[] targetArray = target.toCharArray();
        int k = stamp.length();
        int n = target.length();
        int charsLeft = targetArray.length;
        int maxOperations = 10 * n;
        List<Integer> stampOperations = new ArrayList<>(n);
        while (maxOperations > 0 && charsLeft > 0) {
            boolean found = false;
            for (int i = 0; i < n - k + 1; i++) {
                int index = canBeStamped(i, stampArray, targetArray);
                if (index > 0) {
                    charsLeft -= removeStamp(i, k, targetArray);
                    stampOperations.add(i);
                    found = true;
                    break;
                }
            }
            if (!found) {
                return new int[0];
            }
            maxOperations--;
        }
        if (maxOperations >= 0) {
            int[] result = new int[stampOperations.size()];
            for (int i = stampOperations.size() - 1; i >= 0; i--) {
                result[stampOperations.size() - 1 - i] = stampOperations.get(i);
            }
            return result;
        } else {
            return new int[0];
        }
    }

    private int canBeStamped(int i, char[] stamp, char[] target) {
        boolean unstamped = false;
        int j = 0;
        while (j < stamp.length) {
            if (target[i] != '*') {
                unstamped = true;
            }
            if (stamp[j] != target[i] && target[i] != '*') {
                return -i;
            }
            i++;
            j++;
        }
        return unstamped ? i : 0;
    }

    private int removeStamp(int i, int size, char[] target) {
        int count = 0;
        int limit = size + i;
        while (i < limit) {
            if (target[i] != '*') {
                count++;
            }
            target[i] = '*';
            i++;
        }
        return count;
    }
}
