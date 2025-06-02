package algorithms.prefixsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 2615. Sum of Distances
 */
public class SumOfDistances {
    public long[] distance(int[] nums) {
        long[] arr = new long[nums.length];
        Map<Integer, Long> countMap = new HashMap<>();
        Map<Integer, Long> sumMap = new HashMap<>();
        //count * index - sum of previous indecies
        // 0[0] 2[2] 4[5]
        // sum of following indecies - count * index
        // 5[5] 1[5] 0[3]
        for(int i = 0; i < nums.length; i++) {
            long count = countMap.getOrDefault(nums[i], 0l);
            long sum = sumMap.getOrDefault(nums[i], 0l);
            arr[i] = (long)count * (long)i - sum;
            sum += i;
            count++;
            countMap.put(nums[i], count);
            sumMap.put(nums[i], sum);
        }
        countMap = new HashMap<>();
        sumMap = new HashMap<>();
        for(int i = nums.length-1; i >= 0; i--) {
            long count = countMap.getOrDefault(nums[i], 0l);
            long sum = sumMap.getOrDefault(nums[i], 0l);
            arr[i] += sum - (long)count * (long)i;
            sum += i;
            count++;
            countMap.put(nums[i], count);
            sumMap.put(nums[i], sum);
        }
        return arr;
    }

}
