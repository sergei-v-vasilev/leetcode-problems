package algorithms.graph;

import algorithms.Node;

import java.util.*;

/**
 * 133. Clone Graph
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class CloneGraph {
    public Node cloneGraph(Node node) {
        return cloneGraph(node, new HashMap<>());
    }

    private Node cloneGraph(Node node, Map<Integer, Node> visitedNodes) {
        if (node == null) {
            return null;
        }
        Node n = new Node(node.val);
        visitedNodes.put(node.val, n);
        if (!node.neighbors.isEmpty()) {
            ArrayList<Node> clonedNeighbors = new ArrayList<>();
            for (Node neighbor : node.neighbors) {
                if (visitedNodes.containsKey(neighbor.val)) {
                    clonedNeighbors.add(visitedNodes.get(neighbor.val));
                } else {
                    clonedNeighbors.add(cloneGraph(neighbor, visitedNodes));
                }
            }
            n.neighbors = clonedNeighbors;
        }
        return n;
    }
}
