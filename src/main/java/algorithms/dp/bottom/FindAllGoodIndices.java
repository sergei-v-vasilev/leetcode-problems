package algorithms.dp.bottom;

import java.util.ArrayList;
import java.util.List;

/**
 * 2420. Find All Good Indices
 *
 */
public class FindAllGoodIndices {

    /**
     * [2,1,1,1,3,4,1] 2
     * [1,2,3,4,1,1,2]
     * [1,5,4,3,2,1,1]
     * <p>
     * 1 [2,1] [1,3]
     * 1 [1,1] [3,4]
     * 3 [1,1] [4,1]
     * <p>
     * [0,1,1,1,3,4,5] 3
     * 1 [0,1,1] [1,3,4]
     * 1 [1,1,1] [3,4,5]
     * <p>
     * [1,1,2,3,1,1,1]
     * [6, 5, 4, 3, 2, 1]
     */
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] nonIncreasingDP = new int[nums.length];
        int[] nonDecreasingDP = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                nonIncreasingDP[i] = nonIncreasingDP[i - 1] + 1;
            } else {
                nonIncreasingDP[i] = 1;
            }

            if (i > 0 && nums[nums.length - i] >= nums[nums.length - i - 1]) {
                nonDecreasingDP[nums.length - 1 - i] = nonDecreasingDP[nums.length - i] + 1;
            } else {
                nonDecreasingDP[nums.length - 1 - i] = 1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && i < nums.length - 1 && nonIncreasingDP[i - 1] >= k && nonDecreasingDP[i + 1] >= k) {
                result.add(i);
            }
        }
        return result;
    }

}
