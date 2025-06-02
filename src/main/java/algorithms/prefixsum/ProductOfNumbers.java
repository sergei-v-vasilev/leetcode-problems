package algorithms.prefixsum;

import java.util.ArrayList;
import java.util.List;

/**
 * 1352. Product of the Last K Numbers
 */
class ProductOfNumbers {
    private List<Integer> prefixProd;

    public ProductOfNumbers() {
        prefixProd = new ArrayList<>();
    }

    public void add(int num) {
        if (num != 0) {
            int last = prefixProd.isEmpty() ? 1 : prefixProd.get(prefixProd.size() - 1);
            prefixProd.add(num * last);
        } else {
            prefixProd.clear();
        }
    }

    public int getProduct(int k) {
        if (k > prefixProd.size()) {
            return 0;
        } else if (k == prefixProd.size()) {
            return prefixProd.get(prefixProd.size() - 1);
        } else {
            return prefixProd.get(prefixProd.size() - 1) / prefixProd.get(prefixProd.size() - 1 - k);
        }
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */