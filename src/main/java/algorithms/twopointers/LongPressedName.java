package algorithms.twopointers;

/**
 * 925. Long Pressed Name
 * Time: O(n)
 * Space: O(1)
 */
public class LongPressedName {

    public boolean isLongPressedName(String name, String typed) {
        int left = 0;
        int right = 0;
        while (left < name.length() && right < typed.length()) {
            if (name.charAt(left) == typed.charAt(right)) {
                left++;
                right++;
            } else if (0 < right && typed.charAt(right) == typed.charAt(right - 1)) {
                right++;
            } else return false;
        }
        while (right < typed.length() && typed.charAt(right) == name.charAt(name.length() - 1)) {
            right++;
        }
        return left == name.length() && right == typed.length();
    }
}
