package com.huy;


public abstract class Shape implements Resizable,Comparable<Shape>{
    private String color = "green";
    private boolean filled = true;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    @Override
    public String toString() {
        return "A Shape with color of "
                + getColor()
                + " and "
                + (isFilled() ? "filled" : "not filled");
    }


    @Override
    public void resize() {

    }
    public abstract double getArea();
    @Override
    public int compareTo(Shape shape) {
        if (this.getArea() > shape.getArea()) return 1;
        if (this.getArea() == shape.getArea()) return 0;
        return -1;
    }
}
