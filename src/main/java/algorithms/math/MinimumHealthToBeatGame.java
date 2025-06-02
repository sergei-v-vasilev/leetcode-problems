package algorithms.math;

/**
 * 2214. Minimum Health to Beat Game
 */
public class MinimumHealthToBeatGame {
    public long minimumHealth(int[] damage, int armor) {
        int maxDamage = 0;
        long allDamage = 0;
        for (int i = 0; i < damage.length; i++) {
            allDamage += damage[i];
            maxDamage = Math.max(maxDamage, damage[i]);
        }
        return allDamage - Math.min(armor, maxDamage) + 1;
    }
}
