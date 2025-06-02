package algorithms.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * Time: O(n * 2^n)
 * Space: O(n)
 * 
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<String> palindromes = new LinkedList<>();
        List<List<String>> result = new LinkedList<>();
        return partition(0, s.length(), s, palindromes, result);
    }

    private List<List<String>> partition(int start, int end, String s, List<String> palindromes, List<List<String>> result) {
        if (start == end) {
            result.add(new ArrayList<>(palindromes));
        }
        for (int i = start; i < end; i++) {
            if (isPalindrome(start, i, s)) {
                palindromes.add(s.substring(start, i + 1));
                result = partition(i + 1, end, s, palindromes, result);
                palindromes.remove(palindromes.size() - 1);
            }
        }
        return result;
    }

    private boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
