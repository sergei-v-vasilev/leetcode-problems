package algorithms.dp.top;

import java.util.*;

/**
 * 1462. Course Schedule IV
 */
public class CourseScheduleIV {

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //rows are courses, columns are prerequisites
        boolean[][] prerequisitesTable = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            prerequisitesTable[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        List<Boolean> result = new ArrayList<>(queries.length);
        Map<Integer, Set<Integer>> memo = new HashMap<>();
        for (int[] query : queries) {
            int course = query[1];
            int prerequisite = query[0];
            Set<Integer> allPrerequisites = dfs(course, memo, prerequisitesTable);
            result.add(allPrerequisites.contains(prerequisite));
        }
        return result;
    }

    private Set<Integer> dfs(int course, Map<Integer, Set<Integer>> memo, boolean[][] prerequisitesTable) {
        if (memo.containsKey(course)) {
            return memo.get(course);
        }
        Set<Integer> prerequisites = new HashSet<>();
        for (int i = 0; i < prerequisitesTable[course].length; i++) {
            if (prerequisitesTable[course][i]) {
                prerequisites.add(i);
                prerequisites.addAll(dfs(i, memo, prerequisitesTable));
            }
        }
        memo.put(course, prerequisites);
        return prerequisites;
    }
}
