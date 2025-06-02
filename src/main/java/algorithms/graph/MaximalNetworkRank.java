package algorithms.graph;

import java.util.*;

/**
 * 1615. Maximal Network Rank
 *
 */
public class MaximalNetworkRank {
    private class Node {
        Set<Integer> from; //from this city to another
        Set<Integer> to; //to this city from another

        private Node() {
            from = new HashSet<>();
            to = new HashSet<>();
        }

        private int calculateNumberOfRoadsExcept(int exception) {
            int size = from.size() + to.size();
            if (from.contains(exception)) size--;
            if (to.contains(exception)) size--;
            return size;
        }
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, Node> graph = new HashMap<>(n);
        for (int i = 0; i < roads.length; i++) {
            Node node = graph.getOrDefault(roads[i][0], new Node());
            node.from.add(roads[i][1]);
            graph.put(roads[i][0], node);
            node = graph.getOrDefault(roads[i][1], new Node());
            node.to.add(roads[i][0]);
            graph.put(roads[i][1], node);
        }
        for (int i = 0; i < n; i++) {
            if (!graph.containsKey(i)) graph.put(i, new Node());
        }
        int size;
        Node node;
        int maxRank = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            node = graph.get(i);
            size = node.from.size() + node.to.size();
            for (int j = i + 1; j < n; j++) {
                maxRank = Math.max(maxRank, size + graph.get(j).calculateNumberOfRoadsExcept(i));
            }
        }
        return maxRank;
        
    }
}
