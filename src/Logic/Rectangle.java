package Logic;

import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import view.Canvas;

/**
 * The `Rectangle` class represents a rectangular shape, a geometric figure with
 * four sides, four right angles, and opposite sides of equal length.
 */
public class Rectangle extends Figure {
    private int width;
    private int height;

    /**
     * Constructor for creating a `Rectangle` object.
     *
     * @param point  The starting point of the rectangle.
     * @param width  The width of the rectangle.
     * @param height The height of the rectangle.
     */
    public Rectangle(Point point, int width, int height) {
        super(point);
        this.width = width;
        this.height = height;
    }

    /**
     * Set the width of the rectangle.
     *
     * @param width The width of the rectangle.
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * Set the height of the rectangle.
     *
     * @param height The height of the rectangle.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Get the width of the rectangle.
     *
     * @return The width of the rectangle.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the rectangle.
     *
     * @return The height of the rectangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Calculate the area of the rectangle.
     *
     * @return The calculated area of the rectangle.
     */
    @Override
    public double calcArea() {
        return height * width;
    }

    /**
     * Change the size of the rectangle.
     *
     * @param newWidth  The new width of the rectangle.
     * @param newHeight The new height of the rectangle.
     */
    @Override
    public void changeSize(int newWidth, int newHeight) {
        width = newWidth;
        height = newHeight;
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, color, createRectangleShape());
    }

    /**
     * Create and return the rectangle shape as a Rectangle2D.
     *
     * @return The rectangle shape as a Rectangle2D.
     */
    private Shape createRectangleShape() {
        return new Rectangle2D.Double(point.x, point.y, width, height);
    }

    /**
     * Get the shape of the rectangle.
     *
     * @return The shape of the rectangle.
     */
    @Override
    protected Shape getShape() {
        return createRectangleShape();
    }
}
