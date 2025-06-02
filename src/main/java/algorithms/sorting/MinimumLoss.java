package algorithms.sorting;

import java.util.*;

/**
 * Minimum loss
 * https://www.hackerrank.com/challenges/minimum-loss/problem?isFullScreen=true
 * 
 */
public class MinimumLoss {
    public static int minimumLoss(List<Long> price) {
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < price.size(); i++) {
            map.put(price.get(i), i);
        }
        Collections.sort(price);
        long min = Long.MAX_VALUE;
        for (int i = 1; i < price.size(); i++) {
            long current = price.get(i);
            long previous = price.get(i - 1);
            if (map.get(previous) > map.get(current)) {
                min = Math.min(current - previous, min);
            }
        }
        return (int) min;
    }
}
