package huy.code;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Solve quadratic equation:()");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a:");
        double a = sc.nextDouble();
        System.out.println("Enter b:");
        double b = sc.nextDouble();
        System.out.println("Enter c:");
        double c = sc.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a,b,c);
        System.out.println(equation.getEquation());
        System.out.println(equation.calculateRoots());
    }
}