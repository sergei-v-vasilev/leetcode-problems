package algorithms.bit;

/**
 * 260. Single Number III
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int s = nums[0];
        for (int i = 1; i < nums.length; i++) {
            s = s ^ nums[i];
        }
        s = s & -s;
        int x = 0, y = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((s & nums[i]) == 0) {
                x = x ^ nums[i];
            } else {
                y = y ^ nums[i];
            }
        }
        return new int[]{x, y};
    }
}
