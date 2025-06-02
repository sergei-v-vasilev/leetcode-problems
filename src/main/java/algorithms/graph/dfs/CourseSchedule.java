package algorithms.graph.dfs;

import java.util.*;

/**
 * 207. Course Schedule
 *
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] tree = new ArrayList[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            if (tree[prerequisites[i][0]] == null) {
                tree[prerequisites[i][0]] = new ArrayList<>();
                tree[prerequisites[i][0]].add(prerequisites[i][1]);
            } else {
                tree[prerequisites[i][0]].add(prerequisites[i][1]);
            }
        }
        for (int i = 0; i < tree.length; i++) {
            if (!canFinishCourse(i, tree, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean canFinishCourse(int index, List<Integer>[] tree, Set<Integer> path) {
        if (tree[index] == null || tree[index].size() == 0) {
            return true;
        }
        path.add(index);
        for (int k : tree[index]) {
            if (path.contains(k)) {
                return false;
            }
            if (!canFinishCourse(k, tree, path)) {
                return false;
            }
            tree[k] = null;
        }
        path.remove(index);
        return true;
    }

}
