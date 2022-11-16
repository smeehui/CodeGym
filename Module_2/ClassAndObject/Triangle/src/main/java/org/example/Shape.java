package org.example;

public class Shape {
    private String color;
    private boolean isFilled = false;

    public Shape() {
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

    public String toString() {
        return "A shape " + (this.getColor() != null ? "with color: " + this.getColor() : "") + ", "
                + (this.isFilled() ? "filled." : "not filled");
    }
}
