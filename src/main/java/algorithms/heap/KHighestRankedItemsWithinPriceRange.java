package algorithms.heap;

import java.util.*;

/**
 * 2146. K Highest Ranked Items Within a Price Range
 * 
 */
public class KHighestRankedItemsWithinPriceRange {

    private class Item {
        private final int[] coordinate;
        private final int distance;

        public Item(int[] coordinate, int distance) {
            this.coordinate = coordinate;
            this.distance = distance;
        }
    }

    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        PriorityQueue<Item> queue = new PriorityQueue<>((l, r) -> {
            if (l.distance != r.distance) {
                return Integer.compare(r.distance, l.distance);
            } else if (grid[l.coordinate[0]][l.coordinate[1]] != grid[r.coordinate[0]][r.coordinate[1]]) {
                return Integer.compare(grid[r.coordinate[0]][r.coordinate[1]], grid[l.coordinate[0]][l.coordinate[1]]);
            } else if (l.coordinate[0] != r.coordinate[0]) {
                return Integer.compare(r.coordinate[0], l.coordinate[0]);
            } else {
                return Integer.compare(r.coordinate[1], l.coordinate[1]);
            }
        });
        int[][] distances = new int[grid.length][grid[0].length];
        distances[start[0]][start[1]] = 1;
        LinkedList<Integer[]> list = new LinkedList<>();
        list.add(new Integer[]{start[0], start[1]});
        while (!list.isEmpty()) {
            Integer[] coordinate = list.pollFirst();
            if (coordinate[0] > 0 && distances[coordinate[0] - 1][coordinate[1]] == 0 && grid[coordinate[0] - 1][coordinate[1]] != 0) {
                distances[coordinate[0] - 1][coordinate[1]] = distances[coordinate[0]][coordinate[1]] + 1;
                list.addLast(new Integer[]{coordinate[0] - 1, coordinate[1]});
            }
            if (coordinate[0] < grid.length - 1 && distances[coordinate[0] + 1][coordinate[1]] == 0 && grid[coordinate[0] + 1][coordinate[1]] != 0) {
                distances[coordinate[0] + 1][coordinate[1]] = distances[coordinate[0]][coordinate[1]] + 1;
                list.addLast(new Integer[]{coordinate[0] + 1, coordinate[1]});
            }
            if (coordinate[1] > 0 && distances[coordinate[0]][coordinate[1] - 1] == 0 && grid[coordinate[0]][coordinate[1] - 1] != 0) {
                distances[coordinate[0]][coordinate[1] - 1] = distances[coordinate[0]][coordinate[1]] + 1;
                list.addLast(new Integer[]{coordinate[0], coordinate[1] - 1});
            }
            if (coordinate[1] < grid[0].length - 1 && distances[coordinate[0]][coordinate[1] + 1] == 0 && grid[coordinate[0]][coordinate[1] + 1] != 0) {
                distances[coordinate[0]][coordinate[1] + 1] = distances[coordinate[0]][coordinate[1]] + 1;
                list.addLast(new Integer[]{coordinate[0], coordinate[1] + 1});
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 1 && pricing[0] <= grid[i][j] && grid[i][j] <= pricing[1] && distances[i][j] > 0) {
                    Item item = new Item(new int[]{i, j}, distances[i][j]);
                    queue.add(item);
                    while (queue.size() > k) {
                        queue.poll();
                    }
                }
            }
        }
        LinkedList<List<Integer>> result = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> coordinate = new ArrayList<>(2);
            int[] c = queue.poll().coordinate;
            coordinate.add(c[0]);
            coordinate.add(c[1]);
            result.addFirst(coordinate);
        }
        return result;
    }
}
