package algorithms.slidingwindow;

import java.util.LinkedList;
import java.util.List;

/**
 * 438. Find All Anagrams in a String
 * Time: O(n)
 * Space: O(1)
 * 
 */
public class FindAllAnagramsInString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new LinkedList<>();
        if (p.length() > s.length()) {
            return result;
        }
        int[] template = new int[26];
        for (char letter : p.toCharArray()) {
            template[letter - 'a']++;
        }
        int[] slidingWindow = new int[26];
        char[] array = s.toCharArray();
        for (int i = 0; i < p.length(); i++) {
            slidingWindow[array[i] - 'a']++;
        }
        if (equalToTemplate(slidingWindow, template)) {
            result.add(0);
        }
        int start = 1;
        int end = p.length();
        while (end < s.length()) {
            slidingWindow[array[start - 1] - 'a']--;
            slidingWindow[array[end] - 'a']++;
            if (equalToTemplate(slidingWindow, template)) {
                result.add(start);
            }
            start++;
            end++;
        }
        return result;
    }

    private boolean equalToTemplate(int[] slidingWindow, int[] template) {
        for (int i = 0; i < 26; i++) {
            if (slidingWindow[i] != template[i]) {
                return false;
            }
        }
        return true;
    }
}
