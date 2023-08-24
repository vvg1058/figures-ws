package Logic;

import java.awt.Point;
import java.awt.Shape;
import java.awt.Polygon;

import view.Canvas;

/**
 * The `Triangle` class represents a triangular shape, a geometric figure with
 * three sides and three vertices.
 */
public class Triangle extends Figure {
    private int base;
    private int height;

    /**
     * Constructor for creating a `Triangle` object.
     *
     * @param point  The starting point of the triangle.
     * @param base   The length of the base of the triangle.
     * @param height The height of the triangle.
     */
    public Triangle(Point point, int base, int height) {
        super(point);
        this.base = base;
        this.height = height;
    }

    /**
     * Get the length of the base of the triangle.
     *
     * @return The length of the base of the triangle.
     */
    public int getBase() {
        return base;
    }

    /**
     * Set the length of the base of the triangle.
     *
     * @param base The length of the base of the triangle.
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     * Get the height of the triangle.
     *
     * @return The height of the triangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the height of the triangle.
     *
     * @param height The height of the triangle.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Calculate the area of the triangle.
     *
     * @return The calculated area of the triangle.
     */
    @Override
    public double calcArea() {
        return 0.5 * base * height;
    }

    /**
     * Change the size of the triangle.
     *
     * @param newWidth  The new width of the triangle's base.
     * @param newHeight The new height of the triangle.
     */
    @Override
    public void changeSize(int newWidth, int newHeight) {
        base = newWidth;
        height = newHeight;
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, color, createTriangleShape());
    }

    /**
     * Create and return the triangle shape as a Polygon.
     *
     * @return The triangle shape as a Polygon.
     */
    private Shape createTriangleShape() {
        int[] xPoints = {
                point.x,
                point.x + base,
                point.x + (base / 2)
        };

        int[] yPoints = {
                point.y + height,
                point.y + height,
                point.y
        };

        return new Polygon(xPoints, yPoints, 3);
    }

    /**
     * Get the shape of the triangle.
     *
     * @return The shape of the triangle.
     */
    @Override
    protected Shape getShape() {
        return createTriangleShape();
    }
}
