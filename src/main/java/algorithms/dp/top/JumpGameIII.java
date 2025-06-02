package algorithms.dp.top;

/**
 * 1306. Jump Game III
 * Time: O(n)
 * Space: O(n)
 * 
 */
public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {
        return canReach(start, arr, new boolean[arr.length]);
    }


    private boolean canReach(int start, int[] arr, boolean[] path) {
        if (start < 0 || arr.length <= start || path[start]) {
            return false;
        }
        path[start] = true;
        if (arr[start] == 0) {
            return true;
        }
        return canReach(start + arr[start], arr, path) || canReach(start - arr[start], arr, path);
    }

}
