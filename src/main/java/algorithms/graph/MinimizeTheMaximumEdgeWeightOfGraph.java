package algorithms.graph;

import java.util.*;

/**
 * 3419. (M) Minimize the Maximum Edge Weight of Graph
 */
public class MinimizeTheMaximumEdgeWeightOfGraph {

    // no need to use threshold!
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        //<to, <from, minimal weight>>
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>(n);
        //<from, number of outgoing edges>
        Map<Integer, Integer> outgoing = new HashMap<>(n);

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            Map<Integer, Integer> fromWeight = graph.getOrDefault(to, new HashMap<>());
            if (!fromWeight.containsKey(from) || fromWeight.containsKey(from) && weight < fromWeight.get(from)) {
                fromWeight.put(from, weight);
            }
            graph.put(to, fromWeight);
        }

        //[<from, weight>]
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();
        for (Map.Entry<Integer, Integer> fromWeight : graph.getOrDefault(0, new HashMap<>()).entrySet()) {
            queue.offer(new int[]{fromWeight.getKey(), fromWeight.getValue()});
        }
        visited.add(0);
        int maxWeight = 0;
        while (!queue.isEmpty()) {
            int[] edge = queue.poll();
            int from = edge[0];
            int weight = edge[1];
            if (visited.contains(from)) {
                continue;
            }
            maxWeight = Math.max(maxWeight, weight);
            visited.add(from);
            for (Map.Entry<Integer, Integer> toWeight : graph.getOrDefault(from, new HashMap<>()).entrySet()) {
                queue.offer(new int[]{toWeight.getKey(), toWeight.getValue()});
            }
        }
        if (visited.size() < n) {
            return -1;
        }
        return maxWeight;
    }


}
