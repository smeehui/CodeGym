package main;

import circle.Circle;
import circle.ComparableCircle;

import java.util.Arrays;

public class CircleComparable {
    public static void main(String[] args) {
        ComparableCircle circle1 = new ComparableCircle(5);
        ComparableCircle circle2 = new ComparableCircle(6);
        ComparableCircle circle3 = new ComparableCircle(4);
        Circle []circles = {circle1,circle2,circle3};
        Arrays.sort(circles);
        for (Circle c : circles){
            System.out.println(c.toString());
        }
    }
}
