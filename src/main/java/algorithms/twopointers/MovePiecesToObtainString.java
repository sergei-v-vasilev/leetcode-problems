package algorithms.twopointers;

/**
 * 2337. Move Pieces to Obtain a String
 */
public class MovePiecesToObtainString {
    public boolean canChange(String start, String target) {
        int i = 0;
        while (i < start.length()) {
            if (start.charAt(i) != target.charAt(i)) {
                if (start.charAt(i) == 'L' && target.charAt(i) == '_') return false;
                else if ((start.charAt(i) == 'L' && target.charAt(i) == 'R') ||
                        (start.charAt(i) == 'R' && target.charAt(i) == 'L')) return false;
                else if (start.charAt(i) == '_' && target.charAt(i) == 'R') return false;
                else if (start.charAt(i) == 'R' && target.charAt(i) == '_') {
                    int rCount = 1;
                    i++;
                    while (i < start.length() && isAvailableForR(i, start, target)) {
                        if (start.charAt(i) == 'R') rCount++;
                        if (target.charAt(i) == 'R') rCount--;
                        if (rCount < 0) return false;
                        i++;
                    }
                    if (rCount != 0) return false;
                } else if (start.charAt(i) == '_' && target.charAt(i) == 'L') {
                    int lCount = 1;
                    i++;
                    while (i < start.length() && isAvailableForL(i, start, target)) {
                        if (start.charAt(i) == 'L') lCount--;
                        if (target.charAt(i) == 'L') lCount++;
                        if (lCount < 0) return false;
                        i++;
                    }
                    if (lCount != 0) return false;
                }
            } else {
                i++;
            }
        }
        return true;
    }

    private boolean isAvailableForR(int i, String start, String target) {
        return start.charAt(i) != 'L' && target.charAt(i) != 'L';
    }

    private boolean isAvailableForL(int i, String start, String target) {
        return start.charAt(i) != 'R' && target.charAt(i) != 'R';
    }

}
