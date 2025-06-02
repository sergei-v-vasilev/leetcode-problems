package algorithms.greedy;

import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 3081. Replace Question Marks in String to Minimize Its Value
 */
public class ReplaceQuestionInStringTOMinimizeValue {

    public String minimizeStringValue(String s) {
        int[] capacity = new int[26];
        TreeSet<Character> set = new TreeSet<>((a, b) -> {
            if (capacity[a - 'a'] != capacity[b - 'a']) {
                return Integer.compare(capacity[a - 'a'], capacity[b - 'a']);
            } else {
                return a.compareTo(b);
            }
        });
        for (char c : s.toCharArray()) {
            if (c != '?') {
                capacity[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            set.add((char) ('a' + i));
        }
        PriorityQueue<Character> sorted = new PriorityQueue<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                char c = set.first();
                set.remove(c);
                capacity[c - 'a']++;
                sorted.add(c);
                set.add(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i) == '?' ? sorted.poll() : s.charAt(i);
            builder.append(c);
        }
        return builder.toString();
    }
}
