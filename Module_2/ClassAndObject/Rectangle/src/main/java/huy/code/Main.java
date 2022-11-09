package huy.code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter width:");
        Scanner sc = new Scanner(System.in);
        double width = sc.nextDouble();
        System.out.println("Enter height:");
        double height = sc.nextDouble();
        Rectangle rectangle = new Rectangle(width,height);
        System.out.println("Your Rectangle \n"+ rectangle.display());
        System.out.println("Perimeter of the Rectangle: "+ rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: "+ rectangle.getArea());
    }
}