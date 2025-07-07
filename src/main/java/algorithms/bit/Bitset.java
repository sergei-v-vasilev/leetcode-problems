package algorithms.bit;

import java.util.*;

/**
 * 2166. (M) Design Bitset
 */
public class Bitset {

    private Set<Integer> ones;
    private Set<Integer> zeros;
    private final int size;

    public Bitset(int size) {
        this.ones = new HashSet<>();
        this.zeros = new HashSet<>();
        for (int i = 0; i < size; i++) {
            zeros.add(i);
        }
        this.size = size;
    }

    public void fix(int idx) {
        if (zeros.contains(idx)) {
            zeros.remove(idx);
        }
        ones.add(idx);
    }

    public void unfix(int idx) {
        if (ones.contains(idx)) {
            ones.remove(idx);
        }
        zeros.add(idx);
    }

    public void flip() {
        Set<Integer> tmp = ones;
        ones = zeros;
        zeros = tmp;
    }

    public boolean all() {
        return ones.size() == size;
    }

    public boolean one() {
        return !ones.isEmpty();
    }

    public int count() {
        return ones.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (ones.contains(i)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return sb.toString();
    }

}
