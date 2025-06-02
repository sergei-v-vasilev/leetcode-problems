package algorithms.stack;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 735. Asteroid Collision
 * Time: O(n)
 * Space: O(n)
 *
 */
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(asteroids[0]);
        for (int i = 1; i < asteroids.length; i++) {
            Integer asteroid = list.isEmpty() ? null : list.getLast();
            Integer newAsteroid = asteroids[i];
            while (asteroid != null && asteroid > 0 && newAsteroid < 0) {
                if (Math.abs(asteroid) > Math.abs(newAsteroid)) {
                    newAsteroid = null;
                    break;
                } else if (Math.abs(asteroid) < Math.abs(newAsteroid)) {
                    list.removeLast();
                    asteroid = list.isEmpty() ? null : list.getLast();
                } else {
                    list.removeLast();
                    newAsteroid = null;
                    break;
                }
            }
            if (newAsteroid != null) {
                list.addLast(newAsteroid);
            }
        }
        int[] result = new int[list.size()];
        Iterator<Integer> iterator = list.iterator();
        for (int i = 0; i < list.size(); i++) {
            int asteroid = iterator.next();
            result[i] = asteroid;
        }
        return result;
    }
}
