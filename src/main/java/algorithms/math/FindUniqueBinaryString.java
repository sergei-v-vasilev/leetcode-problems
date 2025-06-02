package algorithms.math;

import java.util.Arrays;

/**
 * 1980. Find Unique Binary String
 */
public class FindUniqueBinaryString {

    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        int expected = 0;
        for (int i = 0; i < nums.length; i++) {
            String expectedBinary = convert(expected, nums.length);
            if (!nums[i].equals(expectedBinary)) {
                return expectedBinary;
            }
            expected++;
        }

        return convert(expected, nums.length);
    }

    private String convert(int i, int n) {
        String binary = Integer.toBinaryString(i);
        if (binary.length() < n) {
            binary = "0".repeat(n - binary.length()) + binary;
        }
        return binary;
    }

    public String findDifferentBinaryStringCantor(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '1' ? 0 : 1);
        }
        return sb.toString();
    }

}
