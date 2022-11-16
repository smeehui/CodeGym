package org.example;


public class Cylinder extends Circle {

    private double height;

    public Cylinder() {
        this.setHeight(1);
    }

    public Cylinder(double height, double radius, String color) {
        this.setHeight(height);
        setRadius(radius);
        setColor(color);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getVolume() {
        return getArea() * this.getHeight();
    }

    @Override
    public String toString() {
        return "A cylinder with height = " + this.getHeight() + ", which is a subclass of " + super.toString();
    }

}