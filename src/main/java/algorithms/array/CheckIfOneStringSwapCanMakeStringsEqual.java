package algorithms.array;

/**
 * 1790. Check if One String Swap Can Make Strings Equal
 */
public class CheckIfOneStringSwapCanMakeStringsEqual {

    public boolean areAlmostEqual(String s1, String s2) {
        Character requiredChar = null;
        Character existingChar = null;
        boolean swapIsDone = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i) && existingChar == null) {
                requiredChar = s1.charAt(i);
                existingChar = s2.charAt(i);
            } else if (s1.charAt(i) != s2.charAt(i)) {
                if (swapIsDone) {
                    return false;
                }
                if (existingChar == s1.charAt(i) && requiredChar == s2.charAt(i)) {
                    swapIsDone = true;
                } else {
                    return false;
                }
            }
        }
        return existingChar == null || swapIsDone;
    }

}
