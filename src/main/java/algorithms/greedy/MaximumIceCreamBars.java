package algorithms.greedy;

import java.util.Arrays;

/**
 * 1833. Maximum Ice Cream Bars
 * 
 */
public class MaximumIceCreamBars {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int iceCreamCount = 0;
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if (coins >= 0) {
                iceCreamCount++;
            } else {
                return iceCreamCount;
            }
        }
        return iceCreamCount;
    }
}
