package algorithms.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2402. Meeting Rooms III
 */
public class MeetingRoomIII {

    private class Room {
        int id;
        int unavailableTill;

        public Room(int id) {
            this.id = id;
            this.unavailableTill = -1;
        }
    }

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));
        int[] usage = new int[n];
        PriorityQueue<Room> unavailable = new PriorityQueue<>((a, b) -> {
            if (a.unavailableTill == b.unavailableTill) {
                return a.id - b.id;
            } else {
                return a.unavailableTill - b.unavailableTill;
            }
        });
        PriorityQueue<Room> available = new PriorityQueue<>(Comparator.comparingInt(a -> a.id));
        for (int i = 0; i < n; i++) {
            available.offer(new Room(i));
        }
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while (!unavailable.isEmpty() && start >= unavailable.peek().unavailableTill) {
                available.add(unavailable.poll());
            }

            Room room;
            if (!available.isEmpty()) {
                //there are available rooms
                room = available.poll();
                room.unavailableTill = end;
            } else {
                //delayed room
                room = unavailable.poll();
                room.unavailableTill = room.unavailableTill + end - start;
            }
            usage[room.id]++;
            unavailable.offer(room);
        }

        int maxUsage = usage[0];
        int roomId = 0;
        for (int i = 1; i < usage.length; i++) {
            if (usage[i] > maxUsage) {
                maxUsage = usage[i];
                roomId = i;
            }
        }
        return roomId;
    }

}
