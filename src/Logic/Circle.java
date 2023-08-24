package Logic;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import view.Canvas;

/**
 * The `Circle` class represents a circular shape, a geometric figure with a
 * center
 * point and a radius.
 */
public class Circle extends Figure {
    private int radius;

    /**
     * Constructor for creating a `Circle` object.
     *
     * @param point  The center point of the circle.
     * @param radius The radius of the circle.
     */
    public Circle(Point point, int radius) {
        super(point);
        this.radius = radius;
    }

    /**
     * Get the radius of the circle.
     *
     * @return The radius of the circle.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Set the radius of the circle.
     *
     * @param radius The radius of the circle.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Calculate the area of the circle.
     *
     * @return The calculated area of the circle.
     */
    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    /**
     * Change the size of the circle.
     *
     * @param newWidth  The new width of the circle (diameter).
     * @param newHeight The new height of the circle (diameter).
     */
    @Override
    public void changeSize(int newWidth, int newHeight) {
        int newRadius = (newWidth + newHeight) / 2;
        radius = newRadius;
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, color, createCircleShape());
    }

    /**
     * Create and return the circle shape as an Ellipse2D.
     *
     * @return The circle shape as an Ellipse2D.
     */
    private Shape createCircleShape() {
        int diameter = radius * 2;
        return new Ellipse2D.Double(point.x - radius, point.y - radius, diameter, diameter);
    }

    /**
     * Get the shape of the circle.
     *
     * @return The shape of the circle.
     */
    @Override
    protected Shape getShape() {
        return createCircleShape();
    }
}
