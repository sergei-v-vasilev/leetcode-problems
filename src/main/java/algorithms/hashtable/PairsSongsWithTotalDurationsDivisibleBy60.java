package algorithms.hashtable;

import java.util.*;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class PairsSongsWithTotalDurationsDivisibleBy60 {
    public int numPairsDivisibleBy60(int[] times) {
        Map<Integer, Integer> map = new HashMap<>(times.length);
        int mod;
        int values;
        int count = 0;
        for (int i = 0; i < times.length; i++) {
            mod = times[i] % 60;
            values = map.getOrDefault(mod == 0 ? 0 : 60 - mod, 0);
            if (values > 0) count += values;
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }
        return count;
    }
}
