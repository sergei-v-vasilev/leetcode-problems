package algorithms.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 1129. Shortest Path with Alternating Colors
 * Time: O(max(m,n)), m - количество ребер, n - количество вершин
 * Space: O(n)
 *
 */
public class ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] answer = new int[n];
        Map<Integer, List<Integer>> redMap = new HashMap<>();
        Map<Integer, List<Integer>> blueMap = new HashMap<>();
        for (int i = 0; i < redEdges.length; i++) {
            List<Integer> adjacent = redMap.getOrDefault(redEdges[i][0], new LinkedList<>());
            adjacent.add(redEdges[i][1]);
            redMap.put(redEdges[i][0], adjacent);
        }
        for (int i = 0; i < blueEdges.length; i++) {
            List<Integer> adjacent = blueMap.getOrDefault(blueEdges[i][0], new LinkedList<>());
            adjacent.add(blueEdges[i][1]);
            blueMap.put(blueEdges[i][0], adjacent);
        }
        LinkedList<Integer> queue = new LinkedList();
        queue.add(0);
        boolean isRed = true;
        int size;
        int path = 1;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0 && !queue.isEmpty()) {
                int node = queue.pollFirst();
                size--;
                List<Integer> adjacent;
                adjacent = isRed ? redMap.get(node) : blueMap.get(node);
                if (adjacent != null) {
                    for (int i : adjacent) {
                        if (answer[i] == 0) answer[i] = path;
                        else answer[i] = Math.min(answer[i], path);
                        queue.addLast(i);
                    }
                }
                if (isRed) redMap.remove(node);
                else blueMap.remove(node);
            }
            path++;
            isRed = !isRed;
        }

        redMap.clear();
        blueMap.clear();
        for (int i = 0; i < redEdges.length; i++) {
            List<Integer> adjacent = redMap.getOrDefault(redEdges[i][0], new LinkedList<>());
            adjacent.add(redEdges[i][1]);
            redMap.put(redEdges[i][0], adjacent);
        }
        for (int i = 0; i < blueEdges.length; i++) {
            List<Integer> adjacent = blueMap.getOrDefault(blueEdges[i][0], new LinkedList<>());
            adjacent.add(blueEdges[i][1]);
            blueMap.put(blueEdges[i][0], adjacent);
        }

        isRed = false;
        path = 1;
        queue.add(0);
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0 && !queue.isEmpty()) {
                int node = queue.pollFirst();
                size--;
                List<Integer> adjacent;
                adjacent = isRed ? redMap.get(node) : blueMap.get(node);
                if (adjacent != null) {
                    for (int i : adjacent) {
                        if (answer[i] == 0) answer[i] = path;
                        else answer[i] = Math.min(answer[i], path);
                        queue.addLast(i);
                    }
                }
                if (isRed) redMap.remove(node);
                else blueMap.remove(node);
            }
            path++;
            isRed = !isRed;

        }
        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == 0) answer[i] = -1;
        }
        answer[0] = 0;
        return answer;
    }

}
