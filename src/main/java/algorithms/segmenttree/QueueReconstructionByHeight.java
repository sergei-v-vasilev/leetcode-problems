package algorithms.segmenttree;

import java.util.*;

/**
 * 406. Queue Reconstruction by Height
 */
public class QueueReconstructionByHeight {

    /**
     * Time: O(n^2)
     * Space: O(n)
     */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(b[0], a[0]);
        });
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }

    /**
     * Time: O(n^3)
     * Space: O(n)
     */
    public int[][] reconstructQueueCubic(int[][] people) {
        LinkedList<Integer> sortedIndices = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            sortedIndices.add(i);
        }
        sortedIndices.sort(Comparator.comparingInt(i -> people[i][0]));
        int[][] queue = new int[people.length][2];
        int i = 0;
        while (!sortedIndices.isEmpty()) {
            int toRemove = -1;
            for (int index : sortedIndices) {
                int size = 0;
                for (int k = 0; k < i; k++) {
                    if (queue[k][0] >= people[index][0]) size++;
                }
                if (size == people[index][1]) {
                    queue[i] = people[index];
                    i++;
                    toRemove = index;
                    break;
                }
            }
            sortedIndices.removeFirstOccurrence(toRemove);
        }
        return queue;
    }
}
