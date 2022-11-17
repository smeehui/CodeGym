package com.huy;

import colorable.Colorable;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(5);
        Circle circle2 = new Circle(3);
        Rectangle rectangle1 = new Rectangle(3,4);
        Rectangle rectangle2 = new Rectangle(7,2);
        Square square = new Square(5,"red",true);
        Shape[] shapes = {circle1, circle2, rectangle1, rectangle2,square};
        for(Shape shape : shapes){
            System.out.println(shape.getArea());
            if(shape instanceof Colorable) System.out.println(((Colorable) shape).howToColor());
        }
    }
}