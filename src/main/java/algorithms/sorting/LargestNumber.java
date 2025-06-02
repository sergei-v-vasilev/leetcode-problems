package algorithms.sorting;

import java.util.Arrays;

/**
 * 179. Largest Number
 * Time: O(n*log(n))
 * Space: O(n)
 *
 */
public class LargestNumber {
    public String largestNumber(int[] nums) {
        String[] values = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(values, (left, right) -> {
            String f = left + right;
            String r = right + left;
            return f.compareTo(r);
        });
        if ("0".equals(values[values.length - 1])) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = nums.length - 1; i >= 0; i--) {
            builder.append(values[i]);
        }
        return builder.toString();
    }

}
