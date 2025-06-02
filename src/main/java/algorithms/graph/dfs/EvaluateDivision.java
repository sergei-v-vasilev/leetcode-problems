package algorithms.graph.dfs;

import java.util.*;

/**
 * 399. Evaluate Division
 */
public class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        //<value_1, <value_2, value>> value_1 = value * value_2
        Map<String, Map<String, Double>> map = new HashMap<>(2 * equations.size());
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            representTree(equation.get(0), equation.get(1), values[i], map);
            representTree(equation.get(1), equation.get(0), 1 / values[i], map);
        }
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            double value = dfs(query.get(0), query.get(1), map, new HashSet<>());
            result[i] = value;
        }
        return result;
    }

    private void representTree(String value1, String value2, double value, Map<String, Map<String, Double>> map) {
        Map<String, Double> subMap = map.getOrDefault(value1, new HashMap<>());
        subMap.put(value2, value);
        map.put(value1, subMap);
    }

    private double dfs(String src, String dest, Map<String, Map<String, Double>> map, Set<String> visited) {
        if (!map.containsKey(src)) {
            return -1;
        }
        visited.add(src);
        Map<String, Double> subMap = map.get(src);
        if (subMap.containsKey(dest)) {
            return subMap.get(dest);
        }
        for (String key : subMap.keySet()) {
            if (!visited.contains(key)) {
                double previous = subMap.get(key);
                double value = dfs(key, dest, map, visited);
                if (value != -1) {
                    return previous * value;
                }
            }
        }
        return -1.0;
    }


}
