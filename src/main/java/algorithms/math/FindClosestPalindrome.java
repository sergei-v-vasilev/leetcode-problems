package algorithms.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 564. Find the Closest Palindrome
 */
public class FindClosestPalindrome {

    public String nearestPalindromic(String n) {
        List<Long> palindromes = getPossiblePalindromes(n);

        long initialValue = Long.parseLong(n);
        long result = 0;
        long diff = Long.MAX_VALUE;
        for (long palindrome : palindromes) {
            if (palindrome == initialValue) continue;
            if (Math.abs(palindrome - initialValue) < diff) {
                diff = Math.abs(palindrome - initialValue);
                result = palindrome;
            } else if (Math.abs(palindrome - initialValue) == diff) {
                result = Math.min(result, palindrome);
            }
        }

        return String.valueOf(result);
    }

    private List<Long> getPossiblePalindromes(String n) {
        long firstHalf = Long.parseLong(n.substring(0, n.length() % 2 == 0 ? n.length() / 2 : n.length() / 2 + 1));
        List<Long> palindromes = new ArrayList<>();
        palindromes.add(constructPalindrome(firstHalf, n.length() % 2 == 0));
        palindromes.add(constructPalindrome(firstHalf + 1, n.length() % 2 == 0));
        palindromes.add(constructPalindrome(firstHalf - 1, n.length() % 2 == 0));
        palindromes.add((long) Math.pow(10, n.length() - 1) - 1);
        palindromes.add((long) Math.pow(10, n.length()) + 1);
        return palindromes;
    }

    private long constructPalindrome(long left, boolean isEven) {
        long result = left;
        if (!isEven) {
            left = left / 10;
        }
        while (left > 0) {
            result = result * 10 + (left % 10);
            left /= 10;
        }
        return result;
    }

}
