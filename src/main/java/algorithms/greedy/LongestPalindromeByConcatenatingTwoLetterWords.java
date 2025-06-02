package algorithms.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words
 *
 */
public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> set = new HashMap<>(words.length);
        int palindromeSize = 0;
        for (String word : words) {
            String reversedWord = new StringBuilder(word).reverse().toString();
            if (set.containsKey(reversedWord)) {
                palindromeSize += 4;
                int value = set.get(reversedWord);
                if (value == 1) {
                    set.remove(reversedWord);
                } else {
                    set.put(reversedWord, value - 1);
                }
            } else {
                set.put(word, set.getOrDefault(word, 0) + 1);
            }
        }
        for (int i = 0; i < 26; i++) {
            char letter = (char) (i + 'a');
            String s = new String(new char[]{letter, letter});
            if (set.containsKey(s)) {
                palindromeSize += 2;
                break;
            }
        }
        return palindromeSize;
    }

}
