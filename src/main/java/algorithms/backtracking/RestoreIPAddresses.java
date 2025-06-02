package algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 * 
 */
public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        return restoreIpAddresses(0, s, new ArrayList<>(), 0);
    }

    private List<String> restoreIpAddresses(int start, String s, List<String> result, int numberCount) {
        long number;
        if (numberCount == 3) {
            if (start > s.length() - 1 || s.charAt(start) == '0' && start != s.length() - 1) {
                return result;
            }
            number = Long.parseLong(s.substring(start));
            if (0 <= number && number <= 255) {
                result.add(s);
            }
        } else {
            if (start > s.length() - 1) {
                return result;
            }
            if (s.charAt(start) == '0' && start != s.length() - 1) {
                return restoreIpAddresses(start + 2, s.substring(0, start) + "0." + s.substring(start + 1), result, numberCount + 1);
            } else {
                String nextS;
                if (start + 1 < s.length()) {
                    number = Integer.parseInt(s.substring(start, start + 1));
                    nextS = s.substring(0, start) + number + "." + s.substring(start + 1);
                    result = restoreIpAddresses(start + 2, nextS, result, numberCount + 1);
                }
                if (start + 2 < s.length()) {
                    number = Integer.parseInt(s.substring(start, start + 2));
                    nextS = s.substring(0, start) + number + "." + s.substring(start + 2);
                    result = restoreIpAddresses(start + 3, nextS, result, numberCount + 1);
                }
                if (start + 3 < s.length()) {
                    number = Long.parseLong(s.substring(start, start + 3));
                    if (0 <= number && number <= 255) {
                        nextS = s.substring(0, start) + number + "." + s.substring(start + 3);
                        result = restoreIpAddresses(start + 4, nextS, result, numberCount + 1);
                    }
                }
            }
        }
        return result;
    }
}
