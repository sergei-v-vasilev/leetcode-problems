package algorithms.graph.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1466. Reorder Routes to Make All Paths Lead to the City Zero
 * Time: O(n)
 * Space: O(n)
 * 35
 */
public class ReorderRoutesMakeAllPathsLeadToCityZero {

    private int min = 0;

    private class Node {
        int i;
        Set<Node> toThis = new HashSet<>(2);
        Set<Node> fromThis = new HashSet<>(2);

    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, Node> map = new HashMap<>(n);
        for (int i = 0; i < connections.length; i++) {
            int[] connection = connections[i];
            Node a = map.getOrDefault(connection[0], new Node());
            Node b = map.getOrDefault(connection[1], new Node());
            a.i = connection[0];
            b.i = connection[1];
            a.fromThis.add(b);
            b.toThis.add(a);
            map.put(connection[0], a);
            map.put(connection[1], b);
        }
        Node capital = map.get(0);
        dfs(capital);
        return min;
    }

    private void dfs(Node node) {
        for (Node n : node.fromThis) {
            min++;
            n.toThis.remove(node);
            dfs(n);
        }
        for (Node n : node.toThis) {
            n.fromThis.remove(node);
            dfs(n);
        }
    }
}
