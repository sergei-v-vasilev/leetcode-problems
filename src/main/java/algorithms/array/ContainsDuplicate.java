package algorithms.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 * Time: O(n)
 * Space: O(n)
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for(int n : nums){
            if(set.contains(n)) return true;
            set.add(n);
        }
        return false;
    }
}
