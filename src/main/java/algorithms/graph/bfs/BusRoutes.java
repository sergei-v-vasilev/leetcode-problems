package algorithms.graph.bfs;

import java.util.*;

/**
 * 815. Bus Routes
 */
public class BusRoutes {

    private class Bus {
        int number;
        Set<Integer> adjacentBuses;
        boolean isTarget = false;

        public Bus(int number) {
            this.number = number;
            this.adjacentBuses = new HashSet<>();
        }
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        //build <bust stop, set<bus>>
        Map<Integer, Set<Integer>> busStopMap = new HashMap<>(10000);
        for (int i = 0; i < routes.length; i++) {
            for (int busStop : routes[i]) {
                Set<Integer> buses = busStopMap.getOrDefault(busStop, new HashSet<>());
                buses.add(i);
                busStopMap.put(busStop, buses);
            }
        }
        //create a graph with connected buses
        Set<Integer> sourceBuses = new HashSet<>();
        Map<Integer, Bus> busMap = new HashMap<>(500);
        for (int busStop : busStopMap.keySet()) {
            Set<Integer> buses = busStopMap.get(busStop);
            for (int busNumber : buses) {
                Bus bus = busMap.getOrDefault(busNumber, new Bus(busNumber));
                for (int adjacentBusNumber : buses) {
                    if (adjacentBusNumber != busNumber) {
                        bus.adjacentBuses.add(adjacentBusNumber);
                    }
                }
                if (busStop == source) {
                    sourceBuses.add(busNumber);
                }
                if (busStop == target) {
                    bus.isTarget = true;
                }
                busMap.put(busNumber, bus);
            }
        }
        //BFS for bus graph
        int min = Integer.MAX_VALUE;
        min = Math.min(min, bfs(sourceBuses, busMap));
        if (min == Integer.MAX_VALUE) {
            return -1;
        } else {
            return min;
        }
    }

    private int bfs(Set<Integer> sourceBuses, Map<Integer, Bus> busMap) {
        Set<Integer> visited = new HashSet<>();
        Queue<Bus> queue = new LinkedList<>();
        for(int source : sourceBuses) {
            queue.add(busMap.get(source));
            visited.add(source);
        }
        int result = 0;
        int size = queue.size();
        while (!queue.isEmpty()) {
            Bus bus = queue.poll();
            visited.add(bus.number);
            if (bus.isTarget) {
                return result + 1;
            }
            for (int adjacentBusNumber : bus.adjacentBuses) {
                if (!visited.contains(adjacentBusNumber)) {
                    queue.add(busMap.get(adjacentBusNumber));
                }
            }
            size--;
            if (size == 0) {
                result++;
                size = queue.size();
            }
        }
        return Integer.MAX_VALUE;
    }
}
