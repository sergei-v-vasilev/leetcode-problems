package algorithms.randomized;

import java.util.*;

/**
 * 710. Random Pick with Blacklist
 */
public class RandomPickWithBlacklist {

    private Random random;
    private List<int[]> intervals;

    public RandomPickWithBlacklist(int n, int[] blacklist) {
        this.random = new Random();
        List<int[]> blacklistIntervals = new LinkedList<>();
        if (blacklist.length != 0) {
            Arrays.sort(blacklist);
            int start = blacklist[0];
            int end = blacklist[0];
            for (int i = 1; i < blacklist.length; i++) {
                if (blacklist[i] != end + 1) {
                    blacklistIntervals.add(new int[]{start, end});
                    start = blacklist[i];
                }
                end = blacklist[i];
            }
            blacklistIntervals.add(new int[]{start, end});
        }
        this.intervals = new ArrayList<>(blacklistIntervals.size() + 1);
        int start = 0;
        int end = 0;
        for (int[] blacklistInterval : blacklistIntervals) {
            end = blacklistInterval[0] - 1;
            if (end != -1) {
                intervals.add(new int[]{start, end});
            }
            start = blacklistInterval[1] + 1;
            end = blacklistInterval[1] + 1;
        }
        if (end < n) {
            intervals.add(new int[]{start, n - 1});
        }
    }

    public int pick() {
        int intervalIndex = random.nextInt(0, intervals.size());
        int[] interval = intervals.get(intervalIndex);
        return random.nextInt(interval[0], interval[1] + 1);
    }
}
