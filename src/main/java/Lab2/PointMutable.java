package Lab2;

/**
 * Mutable {@code Point} class.
 *
 * @author hankd
 * @version 1.0
 * @see Point for an immutable version.
 */
public class PointMutable {
    private double X;
    private double Y;

    PointMutable() {
        X = Y = 0;
    }

    /**
     * @param x the position on the x axis.
     * @param y the position on the y axis.
     */
    PointMutable(double x, double y) {
        X = x;
        Y = y;
    }

    /**
     * Perform {@code Point} translation from its current position.
     *
     * @param x the translation distance on the x axis.
     * @param y the translation distance on the y axis.
     */
    void translate(double x, double y) {
        this.setX(this.X + x);
        this.setY(this.Y + y);
    }

    /**
     * Perform {@code Point} Scaling on both x and y coordinates.
     *
     * @param scale the scaling factor.
     */
    void scale(double scale) {
        this.setX(this.X * scale);
        this.setY(this.Y * scale);
    }


    public void setX(double x) {
        X = x;
    }

    public void setY(double y) {
        Y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
