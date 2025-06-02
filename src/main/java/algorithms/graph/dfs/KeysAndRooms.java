package algorithms.graph.dfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 841. Keys and Rooms
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty() && visitedRooms.size() < rooms.size()) {
            int currentRoom = queue.poll();
            visitedRooms.add(currentRoom);
            List<Integer> keys = rooms.get(currentRoom);
            keys.removeAll(visitedRooms);
            queue.addAll(keys);
        }
        return visitedRooms.size() == rooms.size();
    }

    public boolean canVisitAllRoomsDfs(List<List<Integer>> rooms) {
        Set<Integer> visitedRooms = visitAllRooms(0, rooms, new HashSet<>());
        return visitedRooms.size() == rooms.size();
    }

    private Set<Integer> visitAllRooms(int room, List<List<Integer>> rooms, Set<Integer> visitedRooms) {
        visitedRooms.add(room);
        List<Integer> keys = rooms.get(room);
        for (int key : keys) {
            if (!visitedRooms.contains(key)) {
                visitedRooms = visitAllRooms(key, rooms, visitedRooms);
            }
        }
        return visitedRooms;
    }
}
