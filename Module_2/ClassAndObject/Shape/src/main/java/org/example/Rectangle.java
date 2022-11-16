package org.example;
public class Rectangle extends Shape {

    /**
     * Default constructor
     */
    public Rectangle() {
        this.setWidth(1);
        this.setHeight(1);
    }

    /**
     * 
     */
    private double width;

    /**
     * 
     */
    private double height;

    /**
     * 
     */
    public Rectangle(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
    }

    public Rectangle(double width, double height, String color, boolean isFilled) {
        this.setWidth(width);
        this.setHeight(height);
        setColor(color);
        setFilled(isFilled);
    }

    public double getArea() {
        // TODO implement here
        return this.getWidth()*this.getHeight();
    }

    public double getPerimeter() {
        // TODO implement here
        return (this.getWidth()+this.getHeight())*2;
    }

    @Override
    public String toString() {
        // TODO implement here
        return "A Rectangle with width: "+ this.getWidth() +" and height: "+this.getHeight()+
                ", which is a subclass of " + super.toString();
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}