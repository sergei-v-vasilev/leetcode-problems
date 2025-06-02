package algorithms.slidingwindow;

/**
 * 2672. Number of Adjacent Elements With the Same Color
 */
public class NumberOfAdjacentElementsWithTheSameColor {

    public int[] colorTheArray(int n, int[][] queries) {
        int[] result = new int[queries.length];
        int[] array = new int[n];
        int adjacentPairs = 0;
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int color = queries[i][1];
            //if left element has a pair
            if (index > 0 && array[index] != 0 && array[index - 1] == array[index]) {
                adjacentPairs--;
            }
            //if right element has a pair
            if (index < n - 1 && array[index] != 0 && array[index] == array[index + 1]) {
                adjacentPairs--;
            }

            array[index] = color;

            //check with left element to create a pair
            if (index > 0 && array[index - 1] == array[index]) {
                adjacentPairs++;
            }
            //check with right element to create a pair
            if (index < n - 1 && array[index] == array[index + 1]) {
                adjacentPairs++;
            }

            result[i] = adjacentPairs;
        }
        return result;
    }

}
