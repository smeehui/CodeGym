package org.example;

public class Triangle extends Shape {

    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    public Triangle() {
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean isFilled) {
        super(color, isFilled);
        this.setSide1(side1);
        this.setSide2(side2);
        this.setSide3(side3);
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public double getSide3() {
        return side3;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        return Math.sqrt(this.getHeron() * (this.getHeron() - this.getSide1()) * (this.getHeron() - this.getSide2()) * (this.getHeron() - this.getSide3()));
    }

    public double getHeron() {
        return (this.getSide1() + this.getSide2() + this.getSide3()) / 2;
    }

    public double getPerimeter() {
        return this.getSide1() + this.getSide2() + this.getSide3();
    }

    @Override
    public String toString() {
        return "A rectangle with three sides: "
               + this.getSide1() + ", " + this.getSide2() + ", " + this.getSide3() + ",\n"
               + "perimeter is: " + this.getPerimeter() + ",\n"
               + "area is: " + this.getArea() + "\n"
               + "extended from " + super.toString();
    }

}