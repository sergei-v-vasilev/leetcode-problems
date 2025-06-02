package algorithms.greedy;

/**
 * 926. Flip String to Monotone Increasing
 *
 */
public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int numberOfOnes = 0;
        int numberOfZerosAfterOnes = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (numberOfOnes > 0) {
                    numberOfZerosAfterOnes++;
                }
                if (numberOfZerosAfterOnes == numberOfOnes) {
                    result += numberOfZerosAfterOnes;
                    numberOfZerosAfterOnes = 0;
                    numberOfOnes = 0;
                }
            } else if (s.charAt(i) == '1') {
                numberOfOnes++;
            } else throw new RuntimeException("Failed");
        }
        result += numberOfZerosAfterOnes;
        return result;
    }
}
