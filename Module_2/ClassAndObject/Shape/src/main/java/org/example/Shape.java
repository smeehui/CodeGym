package org.example;

/**
 *
 */
public class Shape {

    /**
     *
     */
    private String color;
    /**
     *
     */
    private boolean isFilled;

    /**
     * Default constructor
     */
    public Shape() {
    }

    public String toString() {
        // TODO implement here
        return "A Shape with color of " + this.getColor()+" and is "+ (this.isFilled()? "filled": "not filed");
    }

    public Shape(String color, boolean isFilled) {
        this.setColor(color);
        this.setFilled(isFilled);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}