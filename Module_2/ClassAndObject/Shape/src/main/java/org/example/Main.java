package org.example;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5,7,"red", true);
        Circle circle = new Circle(5,"red", false);
        Square square = new Square(3,"green", true);
        System.out.println(rectangle+ " area: "+ rectangle.getArea()
                + " ,perimeter: "+ rectangle.getPerimeter()
        );
        System.out.println(circle+ " area: "+ circle.getArea()
                + " ,perimeter: "+ circle.getPerimeter());
        System.out.println(square+ " area: "+ square.getArea()
                + " ,perimeter: "+ square.getPerimeter());
    }
}