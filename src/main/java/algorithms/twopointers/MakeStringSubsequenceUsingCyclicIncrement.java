package algorithms.twopointers;

/**
 * 2825. Make String a Subsequence Using Cyclic Increments
 *
 */
public class MakeStringSubsequenceUsingCyclicIncrement {

    public boolean canMakeSubsequence(String str1, String str2) {
        int initial = 0;
        int subsequent = 0;
        while (initial < str1.length() && subsequent < str2.length()) {
            if (str1.charAt(initial) == str2.charAt(subsequent)) {
                subsequent++;
            } else if (str1.charAt(initial) != 'z' && (str1.charAt(initial) + 1) == str2.charAt(subsequent)) {
                subsequent++;
            } else if (str1.charAt(initial) == 'z' && str2.charAt(subsequent) == 'a') {
                subsequent++;
            }
            initial++;
        }
        return subsequent == str2.length();
    }

}
