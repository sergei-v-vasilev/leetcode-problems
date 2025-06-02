package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1487. Making File Names Unique
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class MakingFileNamesUnique {


    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>(names.length);
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                int count = map.get(name);
                String newName = name + "(" + count + ")";
                while (map.containsKey(newName)) {
                    count++;
                    newName = name + "(" + count + ")";
                }
                map.put(name, count + 1);
                map.put(newName, 1);
                names[i] = newName;
            } else {
                map.put(name, 1);
                names[i] = name;
            }
        }
        return names;
    }
}
