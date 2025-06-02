package algorithms.graph.dfs;


import java.util.*;

/**
 * 332. Reconstruct Itinerary
 * Time: O(|E|)
 * Space: O(|V|+ |E|)
 *
 */
public class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        String from, to;
        for (List<String> ticket : tickets) {
            from = ticket.get(0);
            to = ticket.get(1);
            PriorityQueue<String> destinations = graph.getOrDefault(from, new PriorityQueue<>());
            destinations.add(to);
            graph.put(from, destinations);
        }
        return innerFindItinerary("JFK", graph, itinerary);
    }

    /**
     * This works fine for
     * B <- A -> C -> A
     * C <- A -> B -> A
     * A <- C <- A -> B -> A
     * because of the insertion in the start of the list.
     * We always have the cycle if we have multiple destination from one point
     */
    private LinkedList<String> innerFindItinerary(String from, Map<String, PriorityQueue<String>> graph, LinkedList<String> itinerary) {
        PriorityQueue<String> destinations = graph.getOrDefault(from, new PriorityQueue<>());
        while (!destinations.isEmpty()) {
            itinerary = innerFindItinerary(destinations.poll(), graph, itinerary);
        }
        itinerary.addFirst(from);
        return itinerary;
    }
    
}
