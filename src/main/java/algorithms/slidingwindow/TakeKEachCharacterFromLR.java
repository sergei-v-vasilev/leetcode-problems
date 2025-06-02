package algorithms.slidingwindow;

/**
 * 2516. Take K of Each Character From Left and Right
 */
public class TakeKEachCharacterFromLR {
    public int takeCharacters(String s, int k) {
        int[] counters = new int[3];
        int right = 0;
        while (right < s.length() && (counters[0] < k || counters[1] < k || counters[2] < k)) {
            counters[s.charAt(right) - 'a']++;
            right++;
        }
        if (right == s.length() && (counters[0] < k || counters[1] < k || counters[2] < k)) {
            return -1;
        }
        int result = right;
        right--;
        for (int left = s.length() - 1; left >= 0 && right >=0; left--) {
            counters[s.charAt(left) - 'a']++;
            counters[s.charAt(right) - 'a']--;
            right--;
            if(counters[0] >=k && counters[1] >= k && counters[2] >= k) {
                while (right >= 0 && counters[s.charAt(right)-'a'] > k) {
                    counters[s.charAt(right)-'a'] --;
                    right--;
                }

                result = Math.min(result, right + s.length() - left + 1);
            }
        }
        return result;
    }
}
