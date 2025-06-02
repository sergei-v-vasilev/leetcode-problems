package algorithms.array;

/**
 * 1975. Maximum Matrix Sum
 */
public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        int minElement = Integer.MAX_VALUE;
        int negativeNumbers = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                minElement = Math.min(minElement, Math.abs(matrix[i][j]));
                if (matrix[i][j] < 0) {
                    negativeNumbers++;
                }
                sum += Math.abs(matrix[i][j]);
            }
        }
        if (negativeNumbers % 2 == 0) {
            return sum;
        } else {
            return sum - 2L * minElement;
        }
    }

}
