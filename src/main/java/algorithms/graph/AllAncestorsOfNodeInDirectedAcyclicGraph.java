package algorithms.graph;


import java.util.*;

/**
 * 2192. All Ancestors of a Node in a Directed Acyclic Graph
 *
 */
public class AllAncestorsOfNodeInDirectedAcyclicGraph {

    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        Map<Integer, Set<Integer>> toMap = new HashMap<>(); //<to, from>
        for (int i = 0; i < edges.length; i++) {
            Set<Integer> ancestors = toMap.getOrDefault(edges[i][1], new HashSet<>());
            ancestors.add(edges[i][0]);
            toMap.put(edges[i][1], ancestors);
        }
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, Set<Integer>> ancestorsMap = new HashMap<>(); //<node, ancestors>
        for (int i = 0; i < n; i++) {
            List<Integer> ancestors = new LinkedList<>(findAncestors(i, toMap, ancestorsMap));
            Collections.sort(ancestors);
            result.add(ancestors);
        }
        return result;
    }

    private Set<Integer> findAncestors(int node, Map<Integer, Set<Integer>> toMap, Map<Integer, Set<Integer>> ancestorsMap) {
        if (!ancestorsMap.containsKey(node) && toMap.containsKey(node)) {
            Set<Integer> ancestors = toMap.get(node);
            Set<Integer> allAncestors = new HashSet<>(ancestors);
            for (int ancestor : ancestors) {
                allAncestors.addAll(findAncestors(ancestor, toMap, ancestorsMap));
            }
            ancestorsMap.put(node, allAncestors);
        }
        return ancestorsMap.getOrDefault(node, new HashSet<>());
    }
}
