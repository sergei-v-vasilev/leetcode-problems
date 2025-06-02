package algorithms.dp;

/**
 * 780. Reaching Points
 */
public class ReachingPoints {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        while (sx <= tx && sy <= ty) {
            if (ty > tx) {
                int multiplier = (ty - sy) / tx;
                if (multiplier > 0) {
                    ty -= multiplier * tx;
                } else {
                    ty -= tx;
                }
            } else {
                int multiplier = (tx - sx) / ty;
                if (multiplier > 0) {
                    tx -= multiplier * ty;
                } else {
                    tx -= ty;
                }
            }
            if (sx == tx && sy == ty) {
                return true;
            }
        }
        return false;
    }
}
