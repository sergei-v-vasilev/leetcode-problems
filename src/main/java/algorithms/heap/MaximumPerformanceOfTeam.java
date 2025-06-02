package algorithms.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1383. Maximum Performance of a Team
 */
public class MaximumPerformanceOfTeam {

    class Engineer {
        int speed;
        int efficiency;

        Engineer(int speed, int efficiency) {
            this.speed = speed;
            this.efficiency = efficiency;
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Engineer[] engineers = new Engineer[n];
        for (int i = 0; i < n; i++) {
            engineers[i] = new Engineer(speed[i], efficiency[i]);
        }
        Arrays.sort(engineers, (l, r) -> Integer.compare(r.efficiency, l.efficiency));
        PriorityQueue<Engineer> team = new PriorityQueue<>(Comparator.comparingInt(l -> l.speed));


        long sum = 0;
        long performance = 0;
        int i = 0;
        while (i < n) {
            if (team.size() == k) {
                sum -= team.poll().speed;
            }
            sum += engineers[i].speed;
            team.add(engineers[i]);
            performance = Math.max(performance, sum * engineers[i].efficiency);
            i++;
        }

        return (int) (performance % (int) (1e9 + 7));
    }

}
