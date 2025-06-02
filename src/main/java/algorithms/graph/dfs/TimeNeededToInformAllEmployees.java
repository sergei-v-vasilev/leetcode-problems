package algorithms.graph.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1376. Time Needed to Inform All Employees
 * Time: O(n * m), m - количество подчиненных в одной линии, максимум
 * Space: O(n)
 *
 */
public class TimeNeededToInformAllEmployees {

    private int max = 0;

    private class Node {
        private int informTime;
        private Set<Node> subordinates;

        private Node(int informTime) {
            this.informTime = informTime;
            subordinates = new HashSet<>();
        }

        public void addTime(int time) {
            informTime = informTime + time;
        }
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, Node> employeeMap = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            Node employee = employeeMap.getOrDefault(i, new Node(informTime[i]));
            if (i != headID) {
                Node managerEmployee = employeeMap.getOrDefault(manager[i], new Node(informTime[manager[i]]));
                managerEmployee.subordinates.add(employee);
                employeeMap.put(manager[i], managerEmployee);
            }
            employeeMap.put(i, employee);
        }
        Node head = employeeMap.get(headID);
        inform(head);
        return max;
    }

    private void inform(Node employee) {
        for (Node subordinate : employee.subordinates) {
            subordinate.addTime(employee.informTime);
            max = Math.max(max, subordinate.informTime);
            inform(subordinate);
        }
    }
}
