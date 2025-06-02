package algorithms.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 * Time: O(n)
 * Space: O(1)
 *
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        Map<Character, Integer> dictionary = new HashMap<>(); //is bound by the letters count
        int countOfEven = 0;
        int countOfOdd = 0;
        char c;
        int number;
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            number = dictionary.getOrDefault(c, 0) + 1;
            if (number % 2 == 0) {
                countOfEven += 2;
                countOfOdd--;
            } else {
                countOfOdd++;
            }
            dictionary.put(c, number);
        }
        return countOfOdd > 0 ? countOfEven + 1 : countOfEven;
    }
}
