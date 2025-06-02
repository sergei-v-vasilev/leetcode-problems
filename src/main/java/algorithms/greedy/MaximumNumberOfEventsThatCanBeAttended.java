package algorithms.greedy;

import java.util.*;

/**
 * 1353. Maximum Number of Events That Can Be Attended
 */
public class MaximumNumberOfEventsThatCanBeAttended {

    public int maxEvents(int[][] events) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int[] event : events) {
            start = Math.min(start, event[0]);
            end = Math.max(end, event[1]);
        }
        //event's starts in increasing order
        Arrays.sort(events, (o1, o2) -> {
            if (o1[1] != o2[1]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o2[0], o1[0]);
            }
        });
        //all available days
        TreeSet<Integer> unoccupiedDays = new TreeSet<>();
        for (int i = start; i <= end + 1; i++) {
            unoccupiedDays.add(i);
        }
        int count = 0;
        for (int[] event : events) {
            Integer nextAvailableDay = unoccupiedDays.ceiling(event[0]);
            if (nextAvailableDay != null && nextAvailableDay <= event[1]) {
                count++;
                unoccupiedDays.remove(nextAvailableDay);
            }
        }
        return count;
    }

    public int maxEvents1(int[][] events) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        for (int[] event : events) {
            start = Math.min(start, event[0]);
            end = Math.max(end, event[1]);
        }
        //event's starts in increasing order
        Arrays.sort(events, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o2[1], o1[1]);
            }
        });
        //queue of interval's ends in increasing order
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int index = 0;
        int count = 0;
        for (int i = start; i <= end; i++) {
            //remove all events that was not attended and cannot be attended
            while (!queue.isEmpty() && queue.peek() < i) {
                queue.poll();
            }
            //add new events that are not in the queue
            while (index < events.length && events[index][0] == i) {
                queue.add(events[index][1]);
                index++;
            }
            //get event with the closest end date
            if (!queue.isEmpty()) {
                queue.poll();
                count++;
            }
        }
        return count;
    }

}
