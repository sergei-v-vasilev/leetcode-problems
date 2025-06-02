package algorithms.backtracking;

import java.util.LinkedList;
import java.util.List;

/**
 * 797. All Paths From Source to Target
 * Time: O(|E|+|V|)
 * Space: O(|E|+|V|)
 * 
 */
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        path.add(0);
        allPathsSourceTarget(0, graph, path, result);
        return result;
    }

    private void allPathsSourceTarget(int node, int[][] graph, LinkedList<Integer> path, List<List<Integer>> result) {
        if (node == graph.length - 1) {
            result.add(new LinkedList<>(path));
        } else {
            for (int neighbor : graph[node]) {
                path.addLast(neighbor);
                allPathsSourceTarget(neighbor, graph, path, result);
                path.removeLast();
            }
        }
    }
}
