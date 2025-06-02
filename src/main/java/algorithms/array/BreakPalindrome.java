package algorithms.array;

/**
 * 1328. Break a Palindrome
 */
public class BreakPalindrome {

    public String breakPalindrome(String palindrome) {
        if ("a".equals(palindrome)) {
            return "";
        }
        char[] chars = palindrome.toCharArray();
        for (int i = 0; i < palindrome.length() / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return new String(chars);
            }
        }
        chars[chars.length - 1] = 'b';
        return new String(chars);
    }
}
