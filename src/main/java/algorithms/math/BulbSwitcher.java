package algorithms.math;

/**
 * 319. Bulb Switcher
 * Time: O(1)
 * Space: O(1)
 * 
 */
public class BulbSwitcher {

    //every bulb has been switched at most once from second. Only squares of numbers switch on
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }
}
