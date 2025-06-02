package algorithms.twopointers;

/**
 * 165. Compare Version Numbers
 * Time: O(n)
 * Space: O(1)
 *
 */
public class CompareVersionNumbers {

    public int compareVersion(String version1, String version2) {
        String[] revisions1 = version1.split("\\.");
        String[] revisions2 = version2.split("\\.");
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < revisions1.length && pointer2 < revisions2.length) {
            int i1 = 0, i2 = 0;
            while (i1 < revisions1[pointer1].length() && revisions1[pointer1].charAt(i1) == '0') i1++;
            while (i2 < revisions2[pointer2].length() && revisions2[pointer2].charAt(i2) == '0') i2++;
            int r1 = i1 == revisions1[pointer1].length() ? 0 : Integer.parseInt(revisions1[pointer1].substring(i1));
            int r2 = i2 == revisions2[pointer2].length() ? 0 : Integer.parseInt(revisions2[pointer2].substring(i2));
            if (r1 < r2) return -1;
            else if (r1 > r2) return 1;
            pointer1++;
            pointer2++;
        }
        while (pointer1 < revisions1.length) {
            int i1 = 0;
            while (i1 < revisions1[pointer1].length() && revisions1[pointer1].charAt(i1) == '0') i1++;
            int r1 = i1 == revisions1[pointer1].length() ? 0 : Integer.parseInt(revisions1[pointer1].substring(i1));
            if (r1 > 0) return 1;
            pointer1++;
        }
        while (pointer2 < revisions2.length) {
            int i2 = 0;
            while (i2 < revisions2[pointer2].length() && revisions2[pointer2].charAt(i2) == '0') i2++;
            int r2 = i2 == revisions2[pointer2].length() ? 0 : Integer.parseInt(revisions2[pointer2].substring(i2));
            if (r2 > 0) return -1;
            pointer2++;
        }
        return 0;
    }
}
