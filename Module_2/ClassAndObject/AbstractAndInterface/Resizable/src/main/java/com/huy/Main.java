package com.huy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(3);
        Rectangle rectangle1 = new Rectangle(3,4);
        Rectangle rectangle2 = new Rectangle(7,2);
        Shape[] shapes = {circle1, circle2, rectangle1, rectangle2};
        for (Shape shape: shapes) {
            System.out.println(shape);
        }
        Arrays.sort(shapes);
        for (Shape shape: shapes) {
            System.out.println(shape);
        };
        System.out.println("Before resize");
        for(Shape shape: shapes){
            System.out.println(shape);
        }
        for (Shape shape: shapes){
                shape.resize();
        }
        System.out.println("After resize");
        for(Shape shape: shapes){
            System.out.println(shape);
        }
    }
}