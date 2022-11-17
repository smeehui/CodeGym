package main;

import circle.Circle;
import circle.CircleComparator;

import java.util.Arrays;

public class CircleCompare {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c3 = new Circle(12,"red", true);
        Circle c2 = new Circle(3);
        Circle [] cirArr = {c1,c2,c3};

        System.out.println("Before sort");
        for(Circle circle: cirArr){
            System.out.println(circle.toString());
        }
        CircleComparator comparator = new CircleComparator();
        Arrays.sort(cirArr,comparator);
        System.out.println("After sort");
        for(Circle circle: cirArr){
            System.out.println(circle.toString());
        }
    }
}
