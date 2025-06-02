package algorithms.binarysearch;

import java.util.Arrays;

/**
 * 1385. Find the Distance Value Between Two Arrays
 * Time: O(n*log(n))
 * Space: O(1)
 *
 */
public class FindDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int index = Arrays.binarySearch(arr2, arr1[i]);
            if (index < 0) {
                index = -(index + 1);
            }
            boolean leftCondition = true;
            boolean rightCondition = true;
            if (0 <= index - 1 && index - 1 < arr2.length) {
                leftCondition = Math.abs(arr2[index - 1] - arr1[i]) > d;
            }
            if (0 <= index && index < arr2.length) {
                rightCondition = Math.abs(arr2[index] - arr1[i]) > d;
            }
            if (leftCondition && rightCondition) count++;
        }
        return count;
    }
}
