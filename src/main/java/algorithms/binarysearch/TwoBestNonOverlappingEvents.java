package algorithms.binarysearch;

import java.util.*;

/**
 * 2054. Two Best Non-Overlapping Events
 */
public class TwoBestNonOverlappingEvents {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int[] maximumAfter = new int[events.length];
        int max = Integer.MIN_VALUE;
        for (int i = events.length - 1; i >= 0; i--) {
            max = Math.max(max, events[i][2]);
            maximumAfter[i] = max;
        }
        int result = maximumAfter[0];
        for (int i = 0; i < events.length; i++) {
            int firstNonOverlappingIndex = Arrays.binarySearch(events, new int[]{events[i][1] + 1, 0}, Comparator.comparingInt(a -> a[0]));
            if (firstNonOverlappingIndex < 0) firstNonOverlappingIndex = -(firstNonOverlappingIndex + 1);
            if (firstNonOverlappingIndex != events.length) {
                result = Math.max(result, events[i][2] + maximumAfter[firstNonOverlappingIndex]);
            }
        }
        return result;
    }

}
