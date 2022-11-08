package org.example;

import java.util.Scanner;

public class TempConverter {
    public static void main(String[] args) {
        int selection;
        do {
            System.out.println("Nhập vào chỉ mục tương ứng");
            System.out.println("1. Chuyển đổi độ C sang độ F");
            System.out.println("2. Chuyển đổi độ F sang độ C");
            System.out.println("0. Thoát chương trình");
            Scanner sc = new Scanner(System.in);
            selection = sc.nextInt();
            switch (selection) {
                case 1 -> convertCtoF();
                case 2 -> convertFtoC();
                case 0 -> System.exit(0);
                default -> System.out.println("Nhập sai!");
            }
            System.out.println("------------------------------");
        } while (selection != 0);
    }

    private static void convertFtoC() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào độ F:");
        double f = sc.nextDouble();
        double c = (5.0/9)*(f-32);
        System.out.println( f +" độ F bằng "+ c+ " độ C");
    }

    private static void convertCtoF() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào độ C:");
        double c = sc.nextDouble();
        double f = c*9/5+32;
        System.out.println( c +" độ C bằng "+ f+ " độ F");
    }
}