package org.example;

public class Main {
    public static void main(String[] args) {
        Point point2D = new Point(1,2);
        System.out.println(point2D);
        MovablePoint point1 = new MovablePoint(1,3,2,2);
        System.out.println(point1);
        MovablePoint point2 = point1.move();
        System.out.println(point2);
        MovablePoint point3 = point2.move();
        System.out.println(point3);
        Point point = new MovablePoint(1,2,3,4);
        System.out.println(point);
    }
}