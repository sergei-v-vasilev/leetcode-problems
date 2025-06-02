package algorithms.hashtable;

import java.util.*;

/**
 * 759. Employee free time
 * Time: O(n)
 * Space: O(n)
 *
 */
public class EmployeeFreeTime {

    private class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        Map<Integer, Integer> times = new HashMap<>(avails.size());
        for (List<Interval> list : avails) {
            for (Interval interval : list) {
                times.put(interval.start, times.getOrDefault(interval.start, 0) + 1);
                times.put(interval.end, times.getOrDefault(interval.end, 0) - 1);
            }
        }

        List<Interval> intervals = new LinkedList<>();
        Integer previous = null;
        int sum = 0;
        for (Integer time : times.keySet()) {
            if (previous != null && sum == 0) {
                intervals.add(new Interval(previous, time));
            }
            sum += times.get(time);
            previous = time;
        }

        return intervals;
    }
}
