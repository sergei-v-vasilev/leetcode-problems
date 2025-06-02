package algorithms.graph.bfs;

import java.util.*;

/**
 * 1654. Minimum Jumps to Reach Home
 */
public class MinimumJumpsReachHome {

    public static int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> positions = new HashSet<>();
        for (int forbiddenPosition : forbidden) {
            positions.add(forbiddenPosition);
        }
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int size;
        int path = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (!queue.isEmpty() && size > 0) {
                int[] first = queue.pollFirst();
                size--;
                int position = first[0];
                if (position == x) {
                    return path;
                }
                positions.add(position);
                boolean wasBackward = first[1] == 1;
                if (!positions.contains(position + a) && position + a - b <= x) {
                    queue.addLast(new int[]{position + a, 0});
                }
                if (!wasBackward && !positions.contains(position - b) && position - b > 0) {
                    queue.addLast(new int[]{position - b, 1});
                }
            }
            path++;
        }
        return -1;
    }

}
