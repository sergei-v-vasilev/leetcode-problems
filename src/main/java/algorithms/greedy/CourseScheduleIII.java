package algorithms.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 630. Course Schedule III
 */
public class CourseScheduleIII {

    /**
     * Time O(n * log(n))
     * Space O(n)
     */
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(l -> l[1]));
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int day = 0;
        for (int[] course : courses) {
            int duration = course[0];
            int lastDay = course[1];
            if (day + duration <= lastDay) {
                queue.add(duration);
                day += duration;
            } else if (!queue.isEmpty() && queue.peek() > duration) { //использовать не влезший курс явно выгоднее,
                // чем последний, так как последний дольше текущего
                day += duration - queue.poll();
                queue.add(duration);
            }
        }
        return queue.size();
    }

    public int scheduleCourseUnoptimized(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(l -> l[1]));
        int maxNumberOfDays = courses[courses.length - 1][1] + 1;
        return scheduleCourseDP(0, 0, courses, new Integer[maxNumberOfDays][courses.length]);
    }


    /**
     * Time O(n * d)
     * Space O(n * d)
     */
    public int scheduleCourseDP(int day, int i, int[][] courses, Integer[][] memo) {
        if (i == courses.length || day > memo.length) {
            return 0;
        }
        if (memo[day][i] != null) {
            return memo[day][i];
        }
        int notTakeCurrentCourse = scheduleCourseDP(day, i + 1, courses, memo);
        if (day + courses[i][0] <= courses[i][1]) {
            int takeCurrentCourse = scheduleCourseDP(day + courses[i][0], i + 1, courses, memo);
            memo[day][i] = Math.max(1 + takeCurrentCourse, notTakeCurrentCourse);
        } else {
            memo[day][i] = notTakeCurrentCourse;
        }
        return memo[day][i];
    }

}
