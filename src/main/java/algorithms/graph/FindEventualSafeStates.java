package algorithms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 802. Find Eventual Safe States
 * Time: O(|E|+|V|)
 * Space: O(|E|+|V|)
 *
 */
public class FindEventualSafeStates {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes = new LinkedList<>();
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!checkCycle(i, graph, color)) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    /**
     * color[i] = 0 - not visited node
     * color[i] = 1 - visited node which in the cycle or current path
     * color[i] = 2 - visited safe node
     */
    private boolean checkCycle(int node, int[][] graph, int[] color) {
        int[] adjacentNodes = graph[node];
        color[node] = 1;
        for (int n : adjacentNodes) {
            if (color[n] == 2) {
                continue;
            }
            if (color[n] == 1 || checkCycle(n, graph, color)) {
                return true;
            }
        }
        color[node] = 2;
        return false;
    }
}
