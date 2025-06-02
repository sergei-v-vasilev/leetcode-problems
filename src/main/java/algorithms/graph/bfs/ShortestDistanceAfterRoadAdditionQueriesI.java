package algorithms.graph.bfs;

import java.util.*;

/**
 * 3243. Shortest Distance After Road Addition Queries I
 * T !
 */
public class ShortestDistanceAfterRoadAdditionQueriesI {

    private static class Node {
        int i;
        Set<Node> children;

        public Node(int i) {
            children = new HashSet<>();
            this.i = i;
        }

    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        Node[] nodes = new Node[n];
        Node lastNode = null;
        for (int i = 0; i < n; i++) {
            Node currentNode = new Node(i);
            nodes[i] = currentNode;
            if (lastNode != null) {
                lastNode.children.add(currentNode);
            }
            lastNode = currentNode;
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            nodes[queries[i][0]].children.add(nodes[queries[i][1]]);
            int distance = findShortestDistance(n, nodes[0]) - 1;
            result[i] = distance;
        }
        return result;
    }

    private int findShortestDistance(int n, Node root) {
        boolean[] visited = new boolean[n];
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        int distance = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            while (size > 0) {
                Node currentNode = queue.poll();
                if (currentNode.i == n - 1) {
                    return distance;
                }
                if(visited[currentNode.i]) {
                    size--;
                    continue;
                }
                queue.addAll(currentNode.children);
                visited[currentNode.i] = true;
                size--;
            }
        }
        return distance;
    }
}
