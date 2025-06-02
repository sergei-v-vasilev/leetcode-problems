package algorithms.slidingwindow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2841. Maximum Sum of Almost Unique Subarray
 */
public class MaximumSumAlmostUniqueSubarray {

    public long maxSum(List<Integer> nums, int m, int k) {
        Map<Integer, Integer> slidingWindow = new HashMap<>(k);
        long maxSum = 0;
        long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            //create initial window
            if (i < k) {
                int num = nums.get(i);
                sum += num;
                slidingWindow.put(num, slidingWindow.getOrDefault(num, 0) + 1);
                if (i == k - 1 && slidingWindow.size() >= m) {//when we form initial window and condition is satistfied
                    maxSum = Math.max(maxSum, sum);
                }
            } else { // move window by 1
                //add next
                int num = nums.get(i);
                sum += num;
                slidingWindow.put(num, slidingWindow.getOrDefault(num, 0) + 1);
                //remove from the beginning
                int toRemove = nums.get(i - k);
                sum -= toRemove;
                if (slidingWindow.get(toRemove) == 1) {
                    slidingWindow.remove(toRemove);
                } else {
                    slidingWindow.put(toRemove, slidingWindow.getOrDefault(toRemove, 0) - 1);
                }
                if (slidingWindow.size() >= m) {
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        return maxSum;
    }
}
