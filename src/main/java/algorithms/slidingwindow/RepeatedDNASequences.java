package algorithms.slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 187. Repeated DNA Sequences
 * Time: O(n)
 * Space: O(n)
 *
 */
public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 11) {
            return result;
        }
        Map<String, Integer> dictionary = new HashMap<>();
        String currentDnaSequence;
        int currentNumber;
        for (int i = 10; i < s.length(); i++) {
            currentDnaSequence = s.substring(i - 10, i);
            currentNumber = dictionary.getOrDefault(currentDnaSequence, 0);
            if (currentNumber == 1) {
                result.add(currentDnaSequence);
            }
            dictionary.put(currentDnaSequence, currentNumber + 1);
        }
        return result;
    }
}
