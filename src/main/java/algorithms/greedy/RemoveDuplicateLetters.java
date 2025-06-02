package algorithms.greedy;

import java.util.LinkedList;

/**
 * 316. Remove Duplicate Letters
 *
 */
public class RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        LinkedList<Character> queue = new LinkedList<>();
        boolean[] added = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (queue.isEmpty()) {
                queue.add(c);
                added[c - 'a'] = true;
            } else {
                while (!queue.isEmpty() && c.compareTo(queue.getLast()) < 0 && count[queue.getLast() - 'a'] > 0 && !added[c - 'a']) {
                    added[queue.getLast() - 'a'] = false;
                    queue.pollLast();
                }
                if (!added[c - 'a']) {
                    queue.add(c);
                    added[c - 'a'] = true;
                }
            }
            count[c - 'a']--;
        }
        StringBuilder builder = new StringBuilder();
        for (Character c : queue) {
            if (!added[c - 'a']) {
                continue;
            }
            added[c - 'a'] = false;
            builder.append(c);
        }
        return builder.toString();
    }
}
