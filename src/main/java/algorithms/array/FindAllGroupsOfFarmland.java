package algorithms.array;

import java.util.*;

/**
 * 1992. (M) Find All Groups of Farmland
 *  * Time: O(n*m)
 *  * Space: O(1) (result doesn't count)
 */
public class FindAllGroupsOfFarmland {

    public int[][] findFarmland(int[][] land) {
        LinkedList<int[]> result = new LinkedList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    int[] farmland = constructFarmland(land, i, j);
                    result.add(farmland);
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private int[] constructFarmland(int[][] land, int i, int j) {
        int[] farmland = new int[4];
        farmland[0] = i;
        farmland[1] = j;
        while (i < land.length && land[i][j] == 1) {
            i++;
        }
        i--;
        while (j < land[0].length && land[i][j] == 1) {
            j++;
        }
        j--;
        farmland[2] = i;
        farmland[3] = j;
        destroyTheFarm(land, farmland[0], farmland[1]);
        return farmland;
    }

    private void destroyTheFarm(int[][] land, int i, int j) {
        if (i >= 0 && i < land.length && j >= 0 && j < land[0].length && land[i][j] == 1) {
            land[i][j] = 0;
            destroyTheFarm(land, i + 1, j);
            destroyTheFarm(land, i - 1, j);
            destroyTheFarm(land, i, j + 1);
            destroyTheFarm(land, i, j - 1);
        }
    }

}
