package org.example;

public class Main {
    public static void main(String[] args) {
        Point2D point1 = new Point2D(5,6);
        System.out.println(point1);
        Point3D point2 = new Point3D(6,5,7);
        System.out.println(point2);
//        Casting
        Point2D point1to3D = (Point2D) point2;
//        point1to3D.setZ(10);
        System.out.println(point1to3D);
    }
}