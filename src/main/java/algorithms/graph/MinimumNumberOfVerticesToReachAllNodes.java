package algorithms.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * 1557. Minimum Number of Vertices to Reach All Nodes
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class MinimumNumberOfVerticesToReachAllNodes {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] incomingEdgeCount = new int[n];
        for (List<Integer> pair : edges) {
            incomingEdgeCount[pair.get(1)]++;
        }
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < incomingEdgeCount.length; i++) {
            if (incomingEdgeCount[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }
}
