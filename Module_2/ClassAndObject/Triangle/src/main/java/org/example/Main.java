package org.example;

public class Main {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(4,4,4);
        System.out.println(triangle1);
        Triangle triangle2 = new Triangle(3,4,5,"green",true);
        System.out.println(triangle2);
    }
}