package algorithms.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1431. Kids With the Greatest Number of Candies
 * Time: O(n)
 * Space: O(1)
 */
public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        List<Boolean> result = new ArrayList<>(candies.length);
        for (int candy : candies) {
            if (candy + extraCandies >= max) result.add(true);
            else result.add(false);
        }
        return result;
    }
}
