package algorithms.graph.bfs;

import java.util.*;

/**
 * 1136. Parallel Courses
 */
public class ParallelCourses {

    public int minimumSemesters(int n, int[][] relations) {
        //<prerequisite course, courses>
        Map<Integer, Set<Integer>> prerequisiteMap = new HashMap<>();
        //<course, degree>
        int[] degrees = new int[n+1];
        for (int i = 0; i < relations.length; i++) {
            int[] relation = relations[i];
            Set<Integer> prerequisites = prerequisiteMap.getOrDefault(relation[0], new HashSet<>());
            prerequisites.add(relation[1]);
            prerequisiteMap.put(relation[0], prerequisites);
            degrees[relation[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        int semester = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            semester++;
            while (size > 0) {
                int course = queue.poll();
                for (int nextCourse : prerequisiteMap.getOrDefault(course, new HashSet<>())) {
                    degrees[nextCourse]--;
                    if (degrees[nextCourse] == 0) {
                        queue.add(nextCourse);
                    }
                }
                size--;
            }
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] > 0) {
                return -1;
            }
        }
        return semester;
    }

}
