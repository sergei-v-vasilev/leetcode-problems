package algorithms.twopointers;

import java.util.Arrays;

/**
 * 825. Friends Of Appropriate Ages
 */
public class FriendsOfAppropriateAges {

    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int count = 0;
        int i = 0;
        int lowerBound = 0;
        int upperBound = 0;
        while (i < ages.length) {
            while (lowerBound < i && ages[lowerBound] <= ages[i] / 2 + 7) {
                lowerBound++;
            }
            upperBound = Math.max(upperBound, i + 1);
            while (upperBound < ages.length && ages[upperBound] == ages[i] && ages[upperBound] > ages[i] / 2 + 7) {
                upperBound++;
            }
            count += i - lowerBound;
            count += upperBound - i - 1;
            i++;
        }
        return count;
    }

}
