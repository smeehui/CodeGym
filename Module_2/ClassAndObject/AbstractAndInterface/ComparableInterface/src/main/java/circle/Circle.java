package circle;

import compare.Comparable;
import geometric.Geometric;

public class Circle extends Geometric implements Comparable<Circle> {
    private double radius=1;
    public Circle() {
    }

    public Circle(double radius) {
    this.setRadius(radius);
    }
    public Circle(double radius, String color, boolean isFilled) {
        super(color, isFilled);
        this.setRadius(radius);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI*this.getRadius()*this.getRadius();
    }

    @Override
    public double getPerimeter() {
        return 2*Math.PI*this.getRadius();
    }
    public  String toString(){
        return "Circle with radius: "+ this.getRadius();
    }

    @Override
    public int compareTo(Circle obj) {
        if (this.getRadius() > obj.getRadius()) return 1;
        if (this.getRadius() == obj.getRadius()) return 0;
        return -1;
    }
}
