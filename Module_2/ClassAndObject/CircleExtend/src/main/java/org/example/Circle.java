package org.example;

public class Circle {

    private double radius;
    private String color;

    public Circle() {
        this.setRadius(1);
    }

    public Circle(double radius, String color) {
        this.setRadius(radius);
        this.setColor(color);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getArea() {
        return Math.PI * this.getRadius() * this.getRadius();
    }

    public String toString() {
        return "A cicle with radius: " + this.getRadius() + " and color: " + (this.getColor() == null ? "no color" : this.getColor());
    }
}