package algorithms.hashtable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 609. Find Duplicate File in System
 * 
 */
public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            for (int i = 1; i < parts.length; i++) {
                String content = parts[i].substring(parts[i].indexOf("(") + 1, parts[i].indexOf(")"));
                List<String> list = map.getOrDefault(content, new LinkedList<>());
                list.add(parts[0] + "/" + parts[i].substring(0, parts[i].indexOf("(")));
                map.put(content, list);
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (String content : map.keySet()) {
            if (map.get(content).size() > 1) {
                result.add(map.get(content));
            }
        }
        return result;
    }
}
