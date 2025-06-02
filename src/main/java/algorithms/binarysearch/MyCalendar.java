package algorithms.binarysearch;

import java.util.*;

/**
 * 729. My Calendar I
 * Time: O(n * log (n))
 * Space: O(n)
 *
 */
public class MyCalendar {

    private Map<Integer, Integer> intervals;
    private List<Integer> calendar;

    public MyCalendar() {
        calendar = new ArrayList<>();
        intervals = new HashMap<>();
    }

    public boolean book(int start, int end) {
        int index = Collections.binarySearch(calendar, start);
        if (index >= 0) return false;
        index = -(index + 1) - 1;
        if (index == -1 && calendar.size() > 0) {
            Integer startPeriod = calendar.get(0);
            if (startPeriod != null && end > startPeriod) {
                return false;
            }
        }
        if (index >= 0 && index < calendar.size()) {
            Integer startPeriod = calendar.get(index);
            Integer endPeriod = intervals.get(startPeriod);
            if (startPeriod != null && endPeriod != null) {
                if (startPeriod == start || start < endPeriod) return false;
                if (index + 1 < calendar.size()) {
                    startPeriod = calendar.get(index + 1);
                    if (startPeriod != null && end > startPeriod) return false;
                }
            }
        }
        calendar.add(start);
        intervals.put(start, end);
        calendar.sort(Integer::compareTo);
        return true;
    }
}
