package algorithms.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/**
 * 135. Candy
 */
public class Candy {

    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        for (int i = 0; i < ratings.length; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = ratings.length - 1; i >= 0; i--) {
            if (i < ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }
        }
        int candiesSum = 0;
        for (int i = 0; i < candies.length; i++) {
            candiesSum += candies[i];
        }
        return candiesSum;
    }

    public int candyTreeMap(int[] ratings) {
        //<rating, indices>
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>();
        for (int i = 0; i < ratings.length; i++) {
            Set<Integer> set = map.getOrDefault(ratings[i], new HashSet<>());
            set.add(i);
            map.put(ratings[i], set);
        }
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        while (!map.isEmpty()) {
            int value = map.keySet().iterator().next();
            for (int index : map.get(value)) {
                calculateCandies(index, ratings, candies);
            }
            map.remove(value);
        }
        int candiesSum = 0;
        for (int i = 0; i < candies.length; i++) {
            candiesSum += candies[i];
        }
        return candiesSum;
    }

    private void calculateCandies(int i, int[] ratings, int[] candies) {
        int max = candies[i];
        if (i < ratings.length - 1 && ratings[i] > ratings[i + 1]) {
            max = Math.max(max, candies[i + 1] + 1);
        }
        if (i > 0 && ratings[i] > ratings[i - 1]) {
            max = Math.max(max, candies[i - 1] + 1);
        }
        candies[i] = max;
    }

}
