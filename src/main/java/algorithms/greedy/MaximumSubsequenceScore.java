package algorithms.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2542. Maximum Subsequence Score
 */
public class MaximumSubsequenceScore {

    private class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        int getX() {
            return x;
        }

        int getY() {
            return y;
        }
    }

    //3,1,3,2,2,1,1
    //1,2,3,3,4,4,4
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Pair[] pairs = new Pair[nums2.length];
        for (int i = 0; i < nums2.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i]);
        }
        Arrays.sort(pairs, (a, b) -> b.getY() - a.getY());
        PriorityQueue<Integer> usedNumber = new PriorityQueue<>();
        long result = Integer.MIN_VALUE;
        long sum = 0;

        for (int i = 0; i < pairs.length; i++) {
            int multiplier = pairs[i].getY();
            int value = pairs[i].getX();
            sum += value;
            usedNumber.add(value);

            if (usedNumber.size() > k) {
                sum -= usedNumber.poll();
            }
            if (usedNumber.size() == k) {
                result = Math.max(result, sum * multiplier);
            }
        }
        return result;
    }
}
