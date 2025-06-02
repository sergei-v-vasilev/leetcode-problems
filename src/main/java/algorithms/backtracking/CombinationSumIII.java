package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 * Time: O(target!/k!)
 * Space: O(1)
 */
public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList;
        for (int i = 1; i <= target / k; i++) {
            currentList = new ArrayList<>();
            currentList.add(i);
            result = combinationSum3(i + 1, k - 1, target - i, currentList, result);
        }
        return result;
    }

    private static List<List<Integer>> combinationSum3(int i, int k, int target, List<Integer> currentList, List<List<Integer>> result) {
        if (k == 1) {
            if (i <= target && target < 10) {
                List<Integer> list = new ArrayList<>(currentList);
                list.add(target);
                result.add(list);
            }
            return result;
        } else {
            for (int j = i; j <= target / k; j++) {
                currentList.add(j);
                result = combinationSum3(j + 1, k - 1, target - j, currentList, result);
                currentList.remove(currentList.indexOf(j));
            }
            return result;
        }
    }
}
