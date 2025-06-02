package algorithms.graph.bfs;

import java.util.*;

/**
 * 210. Course Schedule II
 *
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> prerequisitesMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> courses = prerequisitesMap.getOrDefault(prerequisites[i][0], new HashSet<>());
            courses.add(prerequisites[i][1]);
            prerequisitesMap.put(prerequisites[i][0], courses);
        }

        Set<Integer> path = new LinkedHashSet<>();
        for (int k = 0; k < numCourses; k++) {
            if (!prerequisitesMap.containsKey(k)) {
                path.add(k);
            }
        }
        Set<Integer> temp = new LinkedHashSet<>();
        while (!prerequisitesMap.isEmpty()) {
            int size = prerequisitesMap.size();
            temp.clear();
            for (Integer k : prerequisitesMap.keySet()) {
                if (path.containsAll(prerequisitesMap.get(k))) {
                    temp.add(k);
                }
            }
            for (Integer k : temp) {
                prerequisitesMap.remove(k);
                path.add(k);
            }
            if (size == prerequisitesMap.size()) return new int[0];
        }
        int[] result = new int[path.size()];
        int i = 0;
        for (Integer k : path) {
            result[i] = k;
            i++;
        }
        return result;
    }

    private Set<Integer> finishCoursePath(int course, Map<Integer, Set<Integer>> prerequisitesMap, Set<Integer> path) {
        path.add(course);
        if (prerequisitesMap.get(course) == null || prerequisitesMap.get(course).isEmpty()) {
            return path;
        }
        for (Integer nextCourse : prerequisitesMap.get(course)) {
            if (path.contains(nextCourse)) {
                return new HashSet<>();
            }
            Set<Integer> temp = finishCoursePath(nextCourse, prerequisitesMap, path);
            if (!temp.isEmpty()) {
                return temp;
            }
        }
        return new HashSet<>();
    }
}
