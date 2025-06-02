package algorithms.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 2661. First Completely Painted Row or Column
 */
public class FirstCompletelyPaintedRowOrColumn {

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int[] rowPainted = new int[mat.length];
        int[] colPainted = new int[mat[0].length];
        Map<Integer, int[]> indexMap = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                indexMap.put(mat[i][j], new int[]{i, j});
            }
        }
        for (int k = 0; k < arr.length; k++) {
            int[] coordinates = indexMap.get(arr[k]);
            int i = coordinates[0];
            int j = coordinates[1];
            rowPainted[i]++;
            colPainted[j]++;
            if(rowPainted[i] == mat[0].length) {
                return k;
            }
            if(colPainted[j] == mat.length) {
                return k;
            }
        }
        return -1;
    }
}
