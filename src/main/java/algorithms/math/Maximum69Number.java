package algorithms.math;

/**
 * 1323. Maximum 69 Number
 * Time: O(n)
 * Space: O(1)
 *
 */
public class Maximum69Number {
    public int maximum69Number(int num) {
        String presentation = String.valueOf(num);
        for (int i = 0; i < presentation.length(); i++) {
            if (presentation.charAt(i) == '6') {
                return Integer.parseInt(presentation.substring(0, i) + '9' + presentation.substring(i + 1));
            }
        }
        return num;
    }
}
