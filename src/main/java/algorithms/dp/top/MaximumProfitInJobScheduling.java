package algorithms.dp.top;

import java.util.*;

/**
 * 1235. maximum_profit_in_job_scheduling.go
 */
public class MaximumProfitInJobScheduling {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] intervals = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            intervals[i][0] = startTime[i];
            intervals[i][1] = endTime[i];
            intervals[i][2] = profit[i];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        //startTime, fist index
        TreeMap<Integer, Integer> startTimes = new TreeMap<>();
        for (int i = 0; i < intervals.length; i++) {
            if (!startTimes.containsKey(intervals[i][0])) {
                startTimes.put(intervals[i][0], i);
            }
        }
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(0, intervals, startTimes, memo);
    }

    private int dp(int i, int[][] intervals, TreeMap<Integer, Integer> startTimeMap, Map<Integer, Integer> memo) {
        if (i > intervals.length - 1) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int profitSum;
        int endTime = intervals[i][1];
        int profit = intervals[i][2];
        Integer nextStartTime = startTimeMap.ceilingKey(endTime);
        if (nextStartTime != null) {
            profit += dp(startTimeMap.get(nextStartTime), intervals, startTimeMap, memo);
        }
        profitSum = Math.max(profit, dp(i + 1, intervals, startTimeMap, memo));
        memo.put(i, profitSum);
        return profitSum;
    }

}
