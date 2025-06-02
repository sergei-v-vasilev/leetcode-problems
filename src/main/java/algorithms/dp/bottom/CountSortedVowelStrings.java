package algorithms.dp.bottom;

/**
 * 1641. Count Sorted Vowel Strings
 * Time: O(n)
 * Space: O(1)\
 */
public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int num5 = 1;
        int num4 = 0;
        int num3 = 0;
        int num2 = 0;
        int num1 = 0;
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += 5 * num5 + 4 * num4 + 3 * num3 + 2 * num2 + num1;
            num4 += num5;
            num3 += num4;
            num2 += num3;
            num1 += num2;
        }
        return result;
    }
}
