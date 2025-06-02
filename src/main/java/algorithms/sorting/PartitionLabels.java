package algorithms.sorting;

import java.util.*;

/**
 * 763. Partition Labels
 * Time: O(n)
 * Space: O(1)
 *
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i) - 'a']++;
        }
        Map<Character, Integer> map = new HashMap<>(26);
        List<Integer> result = new ArrayList<>();
        int length = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
            } else {
                map.put(s.charAt(i), letters[s.charAt(i) - 'a'] - 1);
            }
            if (map.get(s.charAt(i)) == 0) {
                map.remove(s.charAt(i));
            }
            length++;
            if (map.isEmpty()) {
                result.add(length);
                length = 0;
            }
        }
        return result;
    }

    public List<Integer> partitionLabelsNonOptimal(String s) {
        int[][] intervals = new int[27][2];
        for (int i = 0; i < 27; i++) { // O(1)
            intervals[i][0] = Integer.MAX_VALUE;
        }
        int[] interval;
        for (int i = 0; i < s.length(); i++) {
            interval = intervals[s.charAt(i) - 'a'];
            if (interval[1] < i) {
                interval[1] = i;
            }
            if (interval[0] > i) {
                interval[0] = i;
            }
        }
        List<Integer> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        interval = intervals[0];
        for (int i = 1; i < 27; i++) { // O(1)
            if (intervals[i][0] == Integer.MAX_VALUE) {
                continue;
            }
            if (interval[0] == intervals[i][0] || intervals[i][0] <= interval[1]) {
                interval[1] = Math.max(interval[1], intervals[i][1]);
            } else {
                result.add(interval[1] - interval[0] + 1);
                interval = intervals[i];
            }
        }
        result.add(interval[1] - interval[0] + 1);
        return result;
    }
}
