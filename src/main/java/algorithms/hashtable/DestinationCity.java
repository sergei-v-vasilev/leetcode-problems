package algorithms.hashtable;

import java.util.*;

/**
 * 1436. (E) Destination City
 */
public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Map<String, Integer> destinations = new HashMap<>();
        for (List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);
            if (!destinations.containsKey(to)) {
                destinations.put(to, 0);
            }
            destinations.put(from, destinations.getOrDefault(from, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : destinations.entrySet()) {
            if (entry.getValue() == 0) {
                return entry.getKey();
            }
        }
        return null;
    }
}
