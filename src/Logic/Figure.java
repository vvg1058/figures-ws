package Logic;

import java.awt.Point;
import java.awt.Shape;

import view.Canvas;

/**
 * The abstract class Figure work as a base for various geometric figure types.
 * It implements the ActionFigure interface.
 */

public abstract class Figure implements ActionFigure {
    protected Point point;
    protected String color;
    protected boolean isVisible;

    public Figure(Point point) {
        this.point = point;
        this.color = "black";
        this.isVisible = false;
    }

    // Make this figure visible. If it was already visible, do nothing.
    public void makeVisible() {
        isVisible = true;
        draw();
    }

    // Make this figure invisible. If it was already invisible, do nothing.
    public void makeInvisible() {
        erase();
        isVisible = false;
    }

    public void moveRight(int distance) {
        point.x += distance;
        draw();
    }

    // Move the figure a certain distance to the left.
    public void moveLeft(int distance) {
        point.x -= distance;
        draw();
    }

    // Move the figure a certain distance up.
    public void moveUp(int distance) {
        point.y -= distance;
        draw();
    }

    // Move the figure a certain distance down.
    public void moveDown(int distance) {
        point.y += distance;
        draw();
    }

    // Slowly move the figure horizontally by 'distance' pixels.
    public void slowMoveHorizontal(int distance) {
        int delta = (distance < 0) ? -1 : 1;
        distance = Math.abs(distance);

        for (int i = 0; i < distance; i++) {
            point.x += delta;
            draw();
        }
    }

    // Slowly move the figure vertically by 'distance' pixels.
    public void slowMoveVertical(int distance) {
        int delta = (distance < 0) ? -1 : 1;
        distance = Math.abs(distance);

        for (int i = 0; i < distance; i++) {
            point.y += delta;
            draw();
        }
    }

    // Change the color of the figure.
    public void changeColor(String newColor) {
        color = newColor;
        draw();
    }

    private void draw() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, color, getShape());
        }
    }

    private void erase() {
        if (isVisible) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }

    // Abstract method to get the shape of the figure.
    protected abstract Shape getShape();
}