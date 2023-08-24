package Logic;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;

import view.Canvas;

/**
 * The `Trapezoid` class represents a trapezoid shape, a geometric figure with
 * two parallel sides and two non-parallel sides.
 */
public class Trapezoid extends Figure {
    private int topBase;
    private int bottomBase;
    private int height;

    /**
     * Constructor for creating a `Trapezoid` object.
     *
     * @param point      The starting point of the trapezoid.
     * @param topBase    The length of the top base.
     * @param bottomBase The length of the bottom base.
     * @param height     The height of the trapezoid.
     */
    public Trapezoid(Point point, int topBase, int bottomBase, int height) {
        super(point);
        this.topBase = topBase;
        this.bottomBase = bottomBase;
        this.height = height;
    }

    /**
     * Get the length of the top base of the trapezoid.
     *
     * @return The length of the top base.
     */
    public int getTopBase() {
        return topBase;
    }

    /**
     * Set the length of the top base of the trapezoid.
     *
     * @param topBase The length of the top base.
     */
    public void setTopBase(int topBase) {
        this.topBase = topBase;
    }

    /**
     * Get the length of the bottom base of the trapezoid.
     *
     * @return The length of the bottom base.
     */
    public int getBottomBase() {
        return bottomBase;
    }

    /**
     * Set the length of the bottom base of the trapezoid.
     *
     * @param bottomBase The length of the bottom base.
     */
    public void setBottomBase(int bottomBase) {
        this.bottomBase = bottomBase;
    }

    /**
     * Get the height of the trapezoid.
     *
     * @return The height of the trapezoid.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Set the height of the trapezoid.
     *
     * @param height The height of the trapezoid.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Calculate the area of the trapezoid.
     *
     * @return The calculated area of the trapezoid.
     */
    @Override
    public double calcArea() {
        return 0.5 * (topBase + bottomBase) * height;
    }

    /**
     * Change the size of the trapezoid.
     *
     * @param newWidth  The new width of the trapezoid.
     * @param newHeight The new height of the trapezoid.
     */
    @Override
    public void changeSize(int newWidth, int newHeight) {
        int newTopBase = newWidth;
        int newBottomBase = newWidth + (bottomBase - topBase);
        topBase = newTopBase;
        bottomBase = newBottomBase;
        Canvas canvas = Canvas.getCanvas();
        canvas.draw(this, color, createTrapezoidShape());
    }

    /**
     * Create and return the trapezoid shape as a Polygon.
     *
     * @return The trapezoid shape as a Polygon.
     */
    private Shape createTrapezoidShape() {
        int[] xPoints = {
                point.x,
                point.x + topBase,
                point.x + bottomBase,
                point.x + (bottomBase - topBase) / 2
        };

        int[] yPoints = {
                point.y + height,
                point.y + height,
                point.y,
                point.y
        };

        return new Polygon(xPoints, yPoints, 4);
    }

    /**
     * Get the shape of the trapezoid.
     *
     * @return The shape of the trapezoid.
     */
    @Override
    protected Shape getShape() {
        return createTrapezoidShape();
    }
}