package Logic;

import java.awt.Graphics;

/**
 * The interface ActionFigure defines a set of methods that
 * must be implemented by classes that represent geometric figures.
 */
public interface ActionFigure {
    /**
     * Calculates the area of the figure.
     * 
     * @return The area of the figure as a double value.
     */
    double calcArea();

    /**
     * Changes the size of the figure.
     * 
     * @param newWidth  The new width of the figure.
     * @param newHeight The new height of the figure.
     */
    void changeSize(int newWidth, int newHeight);
}
