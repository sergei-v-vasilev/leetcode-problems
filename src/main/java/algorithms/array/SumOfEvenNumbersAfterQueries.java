package algorithms.array;

/**
 * 985. Sum of Even Numbers After Queries
 * Time: O(n)
 * Space: O(n)
 *
 */
public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int evenSum = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                evenSum += num;
            }
        }
        int i = 0;
        for (int[] query : queries) {
            int index = query[1];
            if (nums[index] % 2 == 0) {
                evenSum -= nums[index];
            }
            nums[index] += query[0];
            if (nums[index] % 2 == 0) {
                evenSum += nums[index];
            }
            result[i] = evenSum;
            i++;
        }
        return result;
    }
}
