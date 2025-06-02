package algorithms.graph;

import java.util.*;

/**
 * 2493. Divide Nodes Into the Maximum Number of Group
 */
public class DivideNodesIntoMaximumNumberGroups {

    private class UnionFind {
        private int[] roots;
        private int[] sizes;

        public UnionFind(int n) {
            roots = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                roots[i] = i;
                sizes[i] = 1;
            }
        }

        public int getRoot(int x) {
            if (x == roots[x]) {
                return x;
            }
            return getRoot(roots[x]);
        }

        public boolean isConnected(int x, int y) {
            return getRoot(x) == getRoot(y);
        }

        public void union(int a, int b) {
            int rootA = getRoot(a);
            int rootB = getRoot(b);
            if (rootA == rootB) {
                return;
            }
            if (sizes[rootA] < sizes[rootB]) {
                roots[rootA] = rootB;
                sizes[rootB] += sizes[rootA];
            } else {
                roots[rootB] = rootA;
                sizes[rootA] += sizes[rootB];
            }
        }
    }

    public int magnificentSets(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>(n);
        UnionFind uf = new UnionFind(n + 1);
        for (int i = 0; i < edges.length; i++) {
            Set<Integer> neighbors = graph.getOrDefault(edges[i][0], new HashSet<>());
            neighbors.add(edges[i][1]);
            graph.put(edges[i][0], neighbors);
            neighbors = graph.getOrDefault(edges[i][1], new HashSet<>());
            neighbors.add(edges[i][0]);
            graph.put(edges[i][1], neighbors);
            uf.union(edges[i][0], edges[i][1]);
        }

        if (!isPossibleToColorify(graph, n)) {
            return -1;
        }

        int[] distances = new int[n + 1];
        for (int i = 1; i < uf.roots.length; i++) {
            int root = uf.getRoot(i);
            distances[root] = Math.max(distances[root], getLongestPath(i, graph, n));
        }
        int max = 0;
        for (int i = 1; i < uf.roots.length; i++) {
            if (uf.roots[i] == i) {
                max += distances[uf.roots[i]];
            }
        }
        return max;
    }

    private boolean isPossibleToColorify(Map<Integer, Set<Integer>> graph, int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> indexMap = new HashMap<>(n);
        queue.add(1);
        int groupIndex = 1;
        int size = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            indexMap.put(node, groupIndex);
            for (Integer neighbor : graph.getOrDefault(node, new HashSet<>())) {
                if (!indexMap.containsKey(neighbor)) {
                    queue.add(neighbor);
                } else {
                    int neighborIndex = indexMap.get(neighbor);
                    if (neighborIndex != groupIndex + 1 && neighborIndex != groupIndex - 1) {
                        return false;
                    }
                }
            }
            size--;
            if (size == 0) {
                size = queue.size();
                groupIndex++;
            }
        }
        return true;
    }

    private int getLongestPath(int root, Map<Integer, Set<Integer>> graph, int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>(n);
        queue.add(root);
        int size = 1;
        int result = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited.add(node);
            for (Integer neighbor : graph.getOrDefault(node, new HashSet<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
            size--;
            if (size == 0) {
                size = queue.size();
                result++;
            }
        }
        return result;
    }
}
