package algorithms.twopointers;

import java.util.Arrays;

/**
 * 475. Heaters
 * 29
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int result = 0;
        int j = 0;
        for (int i = 0; i < houses.length; i++) {
            if (j < heaters.length && houses[i] <= heaters[j]) {
                if (j == 0) {
                    result = Math.max(result, heaters[j] - houses[i]);
                } else {
                    result = Math.max(result, Math.min(heaters[j] - houses[i], houses[i] - heaters[j - 1]));
                }
            } else if (j < heaters.length) {
                j++;
                i--;
            } else {
                result = Math.max(result, houses[i] - heaters[j - 1]);
            }
        }
        return result;
    }
}
