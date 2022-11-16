package org.example;

public class Circle extends Shape {

    /**
     * Default constructor
     */
    public Circle() {
        this.setRadius(1);
    }


    /**
     * 
     */
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


    public  Circle(double radius) {
        this.setRadius(radius);
    }


    public Circle(double radius, String color, boolean isFilled) {
        this.setRadius(radius);
        setColor(color);
        setFilled(isFilled);
    }


    public double getArea() {
        // TODO implement here
        return Math.PI*this.getRadius()*this.getRadius();
    }


    public double getPerimeter() {
        // TODO implement here
        return 2*Math.PI*this.getRadius();
    }

    public String toString() {
        // TODO implement here
        return "A Circle with radius= "+ this.getRadius()+", which is a subclass of "+ super.toString();
    }

}