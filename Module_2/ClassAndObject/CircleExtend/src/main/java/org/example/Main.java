package org.example;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(5, "green");
        Cylinder cylinder = new Cylinder(6, 7, "blue");
        System.out.println(circle + ", area: " + circle.getArea());
        System.out.println(cylinder + ", volume: " + cylinder.getVolume());
    }
}