package algorithms.divideconquer;

/**
 * 2698. Find the Punishment Number of an Integer
 */
public class FindPunishmentNumberOfInteger {

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (satisfySecondCondition(i, 0, String.valueOf(square))) {
                sum += square;
            }
        }
        return sum;
    }

    private boolean satisfySecondCondition(int target, int i, String n) {
        if (i >= n.length() && target == 0) return true;
        else if (i >= n.length()) return false;

        for (int j = i + 1; j <= n.length(); j++) {
            int s = Integer.parseInt(n.substring(i, j));
            if (s > target) {
                break;
            }
            if (satisfySecondCondition(target - s, j, n)) {
                return true;
            }
        }
        return false;
    }
}
