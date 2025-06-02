package algorithms.unionfind;


import java.util.*;

/**
 * 721. Accounts Merge
 * Time: O(n * k * log (nk))
 * Space: O(n)
 *
 */
public class AccountsMerge {

    private class UnionFind {
        int[] values;
        int[] sizes;

        public UnionFind(int n) {
            values = new int[n];
            sizes = new int[n];
            for (int i = 0; i < n; i++) {
                values[i] = i;
                sizes[i] = 1;
            }
        }

        public int root(int i) {
            if (values[i] == i) {
                return i;
            }
            return root(values[i]);
        }

        public void union(int i, int j) {
            int rootI = root(i);
            int rootJ = root(j);
            if (rootI == rootJ) return;
            if (sizes[rootI] < sizes[rootJ]) {
                values[rootI] = rootJ;
                sizes[rootJ] += rootI;
            } else {
                values[rootJ] = rootI;
                sizes[rootI] += rootJ;
            }
        }
    }


    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind unionFind = new UnionFind(accounts.size());
        Map<String, Integer> emails = new HashMap<>(accounts.size() * 10);
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emails.containsKey(email)) {
                    unionFind.union(i, emails.get(email));
                } else {
                    emails.put(email, i);
                }
            }
        }
        Map<Integer, List<String>> mergedAccount = new HashMap<>(accounts.size() * 10);
        for (String email : emails.keySet()) {
            int user = unionFind.root(emails.get(email));
            List<String> es = mergedAccount.getOrDefault(user, new ArrayList<>());
            es.add(email);
            mergedAccount.put(user, es);
        }
        List<List<String>> result = new LinkedList<>();
        for (Integer user : mergedAccount.keySet()) {
            List<String> userEmails = new LinkedList<>();
            userEmails.add("");
            userEmails.addAll(mergedAccount.get(user));
            Collections.sort(userEmails);
            userEmails.set(0, accounts.get(user).get(0));
            result.add(userEmails);
        }
        return result;
    }
}