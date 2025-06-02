package algorithms.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 1072. Flip Columns For Maximum Number of Equal Rows
 */
public class FlipColumnsForMaximumNumberOfEqualRows {

    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> changes = new HashMap<>(matrix.length);
        int max = 0;
        int zeroNumber;
        int oneNumber;
        for (int i = 0; i < matrix.length; i++) {
            StringBuilder builderZeros = new StringBuilder();
            StringBuilder builderOnes = new StringBuilder();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    builderOnes.append(j);
                }
                if (matrix[i][j] == 1) {
                    builderZeros.append(j);
                }
            }
            zeroNumber = changes.getOrDefault(builderZeros.toString(), 0) + 1;
            oneNumber = changes.getOrDefault(builderOnes.toString(), 0) + 1;
            changes.put(builderZeros.toString(), zeroNumber);
            changes.put(builderOnes.toString(), oneNumber);
            max = Math.max(max, Math.max(zeroNumber, oneNumber));
        }
        return max;
    }
}
