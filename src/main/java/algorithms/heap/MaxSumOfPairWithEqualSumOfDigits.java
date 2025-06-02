package algorithms.heap;

import java.util.*;

/**
 * 2342. Max Sum of a Pair With Equal Sum of Digits
 */
public class MaxSumOfPairWithEqualSumOfDigits {
    public int maximumSum(int[] nums) {
        int[] sumOfDigitsArray = new int[nums.length];
        //<sum of digits, number>
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>(100);
        for (int i = 0; i < nums.length; i++) {
            int sumOfDigits = sumOfDigits(nums[i]);
            sumOfDigitsArray[i] = sumOfDigits;
            PriorityQueue<Integer> queue = map.getOrDefault(sumOfDigits, new PriorityQueue<>());
            queue.add(nums[i]);
            if (queue.size() > 2) {
                queue.poll();
            }
            map.put(sumOfDigits, queue);
        }
        int maxSum = -1;
        for (int i = 0; i < sumOfDigitsArray.length; i++) {
            PriorityQueue<Integer> queue = map.get(sumOfDigitsArray[i]);
            if (queue.size() == 2) {
                maxSum = Math.max(maxSum, queue.poll() + queue.poll());
            }
        }
        return maxSum;
    }

    private int sumOfDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
