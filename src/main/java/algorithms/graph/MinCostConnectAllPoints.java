package algorithms.graph;

import java.util.*;

/**
 * 1584. Min Cost to Connect All Points
 * Kruskal's algorithm
 */
public class MinCostConnectAllPoints {

    private class UnionFind {
        Map<String, String> parents;
        Map<String, Integer> sizes;

        public UnionFind(int[][] points) {
            parents = new HashMap<>();
            sizes = new HashMap<>();
            for (int i = 0; i < points.length; i++) {
                String p = stringify(points[i]);
                parents.put(p, p);
                sizes.put(p, 1);
            }
        }

        public String getParent(String p) {
            if (parents.get(p).equals(p)) return p;
            return getParent(parents.get(p));
        }

        public boolean union(String p, String q) {
            String parentP = getParent(p);
            String parentQ = getParent(q);
            if (parentP.equals(parentQ)) return false;

            if (sizes.get(parentP) < sizes.get(parentQ)) {
                parents.put(parentP, parentQ);
                sizes.put(parentQ, sizes.get(parentP) + sizes.get(parentQ));
            } else {
                parents.put(parentQ, parentP);
                sizes.put(parentQ, sizes.get(parentP) + sizes.get(parentQ));
            }
            return true;
        }
    }

    private class Edge {
        int[] start;
        int[] end;
        int distance;

        public Edge(int[] start, int[] end, int distance) {
            this.start = start;
            this.end = end;
            this.distance = distance;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                Edge edge = new Edge(points[i], points[j], manhattanDistance(points[i], points[j]));
                queue.offer(edge);
            }
        }
        UnionFind uf = new UnionFind(points);
        int edgesCount = 0;
        int cost = 0;
        while (!queue.isEmpty() && edgesCount < points.length - 1) {
            Edge edge = queue.poll();
            if (uf.union(stringify(edge.start), stringify(edge.end))) {
                edgesCount++;
                cost += edge.distance;
            }
        }
        return cost;
    }

    private int manhattanDistance(int[] start, int[] end) {
        return Math.abs(start[0] - end[0]) + Math.abs(start[1] - end[1]);
    }

    private String stringify(int[] point) {
        return String.format("%d,%d", point[0], point[1]);
    }

}
