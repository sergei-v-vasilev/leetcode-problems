package algorithms.backtracking;

import java.util.*;

/**
 * 267. Palindrome Permutation II
 * 18.38 - 19.16
 */
public class PalindromePermutationsII {

    public List<String> generatePalindromes(String s) {
        if (s.length() == 1) {
            return List.of(s);
        }
        int[] letters = new int[26];
        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        if (!canBePalindrome(letters)) {
            return new ArrayList<>();
        }
        List<String> result = new LinkedList<>();
        result = backtrack(new StringBuilder(), s.length(), letters, new int[26], result);
        return result;
    }

    private boolean canBePalindrome(int[] letters) {
        boolean hasOdd = false;
        for (int i = 0; i < 26; i++) {
            if (letters[i] % 2 == 1 && !hasOdd) {
                hasOdd = true;
            } else if (letters[i] % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    private List<String> backtrack(StringBuilder builder, int size, int[] letters, int[] usedLetters, List<String> result) {
        if (builder.length() == size / 2) {
            StringBuilder newBuilder = new StringBuilder(builder.toString());
            if (size % 2 == 0) {
                result.add(mirror(size, newBuilder).toString());
            } else {
                for (int i = 0; i < 26; i++) {
                    if (letters[i] % 2 == 1) {
                        newBuilder.append((char) (i + 'a'));
                        break;
                    }
                }
                result.add(mirror(size, newBuilder).toString());
            }
        } else {
            for (int i = 0; i < 26; i++) {
                if (letters[i] > 0 && usedLetters[i] < letters[i] / 2) {
                    builder.append((char) (i + 'a'));
                    usedLetters[i]++;
                    result = backtrack(builder, size, letters, usedLetters, result);
                    usedLetters[i]--;
                    builder.deleteCharAt(builder.length() - 1);
                }
            }
        }
        return result;
    }

    private StringBuilder mirror(int size, StringBuilder builder) {
        for (int i = 0; i < size / 2; i++) {
            builder.append(builder.charAt(size / 2 - 1 - i));
        }
        return builder;
    }
}
