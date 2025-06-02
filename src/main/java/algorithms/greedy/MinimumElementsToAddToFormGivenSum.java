package algorithms.greedy;

/**
 * 1785. Minimum Elements to Add to Form a Given Sum
 */
public class MinimumElementsToAddToFormGivenSum {
    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        int counter = 0;
        if (sum != goal) {
            int numberOfLimits;
            counter += Math.abs(sum - goal) / limit;
            if(Math.abs(sum - goal) % limit != 0){
                counter++;
            }
        }
        return counter;
    }
}
