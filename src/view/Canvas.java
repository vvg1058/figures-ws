package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.*;

/**
 * The `Canvas` class provides a graphical canvas for drawing and displaying
 * shapes.
 * It manages graphical elements, their colors, and visibility on the canvas.
 */
public class Canvas {

    private static Canvas canvasSingleton;

    /**
     * Get the singleton instance of the Canvas class.
     *
     * @return The singleton instance of the Canvas class.
     */
    public static Canvas getCanvas() {
        if (canvasSingleton == null) {
            canvasSingleton = new Canvas("Paint figures", 550, 550,
                    Color.white);
        }
        canvasSingleton.setVisible(true);
        return canvasSingleton;
    }

    private JFrame frame;
    private CanvasPane canvas;
    private Graphics2D graphic;
    private Color backgroundColour;
    private Image canvasImage;
    private List<Object> objects;
    private HashMap<Object, ShapeDescription> shapes;

    /**
     * Constructor for creating a Canvas object.
     *
     * @param title    The title to appear in the Canvas Frame.
     * @param width    The desired width for the canvas.
     * @param height   The desired height for the canvas.
     * @param bgColour The desired background color of the canvas.
     */
    private Canvas(String title, int width, int height, Color bgColour) {
        frame = new JFrame();
        canvas = new CanvasPane();
        frame.setContentPane(canvas);
        frame.setTitle(title);
        canvas.setPreferredSize(new Dimension(width, height));
        backgroundColour = bgColour;
        frame.pack();
        objects = new ArrayList<Object>();
        shapes = new HashMap<Object, ShapeDescription>();
    }

    /**
     * Set the canvas visibility and brings canvas to the front of the screen when
     * made visible.
     *
     * @param visible Boolean value representing the desired visibility of the
     *                canvas (true or false).
     */
    public void setVisible(boolean visible) {
        if (graphic == null) {
            Dimension size = canvas.getSize();
            canvasImage = canvas.createImage(size.width, size.height);
            graphic = (Graphics2D) canvasImage.getGraphics();
            graphic.setColor(backgroundColour);
            graphic.fillRect(0, 0, size.width, size.height);
            graphic.setColor(Color.black);
        }
        frame.setVisible(visible);
    }

    /**
     * Draw a shape on the canvas with a given color.
     *
     * @param referenceObject The reference object associated with the shape.
     * @param color           The color of the shape.
     * @param shape           The shape to be drawn.
     */
    public void draw(Object referenceObject, String color, Shape shape) {
        objects.remove(referenceObject); // Just in case it was already there
        objects.add(referenceObject); // Add at the end
        shapes.put(referenceObject, new ShapeDescription(shape, color));
        redraw();
    }

    /**
     * Erase a shape from the canvas.
     *
     * @param referenceObject The reference object associated with the shape to be
     *                        erased.
     */
    public void erase(Object referenceObject) {
        objects.remove(referenceObject); // Just in case it was already there
        shapes.remove(referenceObject);
        redraw();
    }

    /**
     * Set the foreground color for drawing shapes.
     *
     * @param colorString The color string specifying the desired color.
     */
    public void setForegroundColor(String colorString) {
        if (colorString.equals("red"))
            graphic.setColor(Color.red);
        else if (colorString.equals("black"))
            graphic.setColor(Color.black);
        else if (colorString.equals("blue"))
            graphic.setColor(Color.blue);
        else if (colorString.equals("yellow"))
            graphic.setColor(Color.yellow);
        else if (colorString.equals("green"))
            graphic.setColor(Color.green);
        else if (colorString.equals("magenta"))
            graphic.setColor(Color.magenta);
        else if (colorString.equals("white"))
            graphic.setColor(Color.white);
        else
            graphic.setColor(Color.black);
    }

    /**
     * Wait for a specified number of milliseconds.
     *
     * @param milliseconds The number of milliseconds to wait.
     */
    public void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Exception e) {
            // Ignoring exception at the moment
        }
    }

    /**
     * Redraw the canvas with the current shapes.
     */
    private void redraw() {
        erase();
        for (Iterator i = objects.iterator(); i.hasNext();) {
            ((ShapeDescription) shapes.get(i.next())).draw(graphic);
        }
        canvas.repaint();
    }

    /**
     * Erase the entire canvas.
     */
    private void erase() {
        Color original = graphic.getColor();
        graphic.setColor(backgroundColour);
        Dimension size = canvas.getSize();
        graphic.fill(new Rectangle(0, 0, size.width, size.height));
        graphic.setColor(original);
    }

    public Image getGraphics() {
        return canvasImage;
    }

    /**
     * A JPanel subclass used for rendering the canvas image.
     */
    private class CanvasPane extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(canvasImage, 0, 0, null);
        }
    }

    /**
     * A class to describe the shape and color of a drawn object.
     */
    private class ShapeDescription {
        private Shape shape;
        private String colorString;

        public ShapeDescription(Shape shape, String color) {
            this.shape = shape;
            colorString = color;
        }

        public void draw(Graphics2D graphic) {
            setForegroundColor(colorString);
            graphic.fill(shape);
        }
    }
}
