package algorithms.randomized;


/**
 * 478. Generate Random Point in a Circle
 */
public class GenerateRandomPointInCircle {

    private double radius;
    private double x;
    private double y;

    public GenerateRandomPointInCircle(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double ang = Math.random() * 2 * Math.PI,
                hyp = Math.sqrt(Math.random()) * radius,
                adj = Math.cos(ang) * hyp,
                opp = Math.sin(ang) * hyp;
        return new double[]{x + adj, y + opp};
    }
}
