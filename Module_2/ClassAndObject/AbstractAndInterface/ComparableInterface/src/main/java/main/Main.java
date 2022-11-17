package main;

import circle.ComparableCircle;

public class Main {
    public static void main(String[] args) {
        ComparableCircle circle1 = new ComparableCircle(5);
        ComparableCircle circle2 = new ComparableCircle(6);
        System.out.println(circle1.compareTo(circle2));
        System.out.println(circle1.getArea());
        System.out.println(circle2.getArea());
    }
}
