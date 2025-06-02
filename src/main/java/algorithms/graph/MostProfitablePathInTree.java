package algorithms.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2467. Most Profitable Path in a Tree
 */
public class MostProfitablePathInTree {

    private class Gate {
        int depth = -1;
        int price = 0;
        Set<Integer> neighbours;

        Gate(int price) {
            this.neighbours = new HashSet<>();
            this.price = price;
        }
    }

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        Map<Integer, Gate> gates = new HashMap<>(amount.length);
        Gate root = new Gate(amount[0]);
        gates.put(0, root);
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Gate start = gates.getOrDefault(edge[0], new Gate(amount[edge[0]]));
            Gate end = gates.getOrDefault(edge[1], new Gate(amount[edge[1]]));
            start.neighbours.add(edge[1]);
            end.neighbours.add(edge[0]);
            gates.put(edge[0], start);
            gates.put(edge[1], end);
        }

        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        int allTime = findBob(0, bob, gates, visited, 0);
        visited.clear();
        visited.add(0);
        return dfs(0, 0, gates, visited, allTime);
    }

    private int dfs(int root, int time, Map<Integer, Gate> gates, Set<Integer> visited, int allTime) {
        Gate rootGate = gates.get(root);
        int max;
        if (rootGate.depth != -1 && allTime - rootGate.depth < time) {
            max = 0;
        } else if (rootGate.depth != -1 && allTime - rootGate.depth == time) {
            max = rootGate.price / 2;
        } else {
            max = rootGate.price;
        }
        boolean isLeaf = true;
        int maxResult = Integer.MIN_VALUE;
        for (int neighbour : rootGate.neighbours) {
            if (!visited.contains(neighbour)) {
                isLeaf = false;
                visited.add(neighbour);
                maxResult = Math.max(maxResult, dfs(neighbour, time + 1, gates, visited, allTime));
                visited.remove(neighbour);

            }
        }
        return isLeaf ? max : max + maxResult;
    }

    private int findBob(int root, int bob, Map<Integer, Gate> gates, Set<Integer> visited, int time) {
        Gate rootGate = gates.get(root);
        if (root == bob) {
            rootGate.depth = time;
            return rootGate.depth;
        }
        for (int neighbour : rootGate.neighbours) {
            if (!visited.contains(neighbour)) {
                visited.add(neighbour);
                int result = findBob(neighbour, bob, gates, visited, time + 1);
                if (result != -1) {
                    rootGate.depth = time;
                    return result;
                }
            }
        }
        return -1;
    }

}
