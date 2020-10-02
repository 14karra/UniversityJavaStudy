package Lab2;

import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * Immutable class.
 *
 * @author hankd
 * @version 1.0
 * @see PointMutable for a mutable version.
 */
@Immutable
public final class Point {
    private final double X;
    private final double Y;

    Point() {
        X = Y = 0;
    }

    /**
     * @param x the position on the x axis.
     * @param y the position on the y axis.
     */
    Point(double x, double y) {
        X = x;
        Y = y;
    }

    /**
     *
     * @param x the position on the x axis.
     * @param y the position on the y axis.
     * @return new {@code Point} object.
     */
    Point translate(double x, double y) {
        return new Point(this.getX() + x, this.getY() + y);
    }

    /**
     * Perform {@code Point} Scaling on both x and y coordinates.
     *
     * @param scale the scaling factor.
     * @return new {@code Point} object.
     */
    Point scale(double scale){
        return new Point(this.getX() * scale, this.getY() * scale);
    }

    private double getX() {
        return X;
    }

    private double getY() {
        return Y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "X=" + X +
                ", Y=" + Y +
                '}';
    }
}
