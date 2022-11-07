package org.example;

import java.util.Scanner;

public class DrawShapes {
    public static void main(String[] args) {
        int selection;
        do {
            System.out.println("Chọn hình vẽ:");
            System.out.println("1. Hình chữ nhật.");
            System.out.println("2. Hình tam giác vuông");
            System.out.println("3. Hình tam giác vuông ngược");
            System.out.println("4. Exit");
            Scanner sc = new Scanner(System.in);
            selection = sc.nextInt();
            switch (selection) {
                case 1:
                    drawRectangle();
                    break;
                case 2:
                    drawSquareTriangle();
                    break;
                case 3:
                    drawIsoslesTriangle();
                case 4:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Sai lựa chọn");
            }
        } while (selection != 4);
    }

    private static void drawIsoslesTriangle() {
        System.out.println("Vẽ hình tạm giác vuông ngược:");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều cao:");
        int height = sc.nextInt();
        for (int i = height; i > 0; i--) {
            System.out.println("  *".repeat(i));
        }
    }

    private static void drawSquareTriangle() {
        System.out.println("Vẽ tam giác vuông");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều cao:");
        int height = sc.nextInt();
        for (int i = 0; i < height; i++) {
            String line = "";
            for (int j = 0; j < i; j++) {
                line += "  *";
            }
            System.out.println(line);
        }
    }

    private static void drawRectangle() {
        System.out.println("Vẽ hình chữ nhật");
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chiều dài:");
        int longSide = sc.nextInt();
        System.out.println("Nhập chiều rộng:");
        int shortSide = sc.nextInt();
        for (int i = 0; i < shortSide; i++) {
            String rect = "";
            for (int j = 0; j < longSide; j++) {
                rect += "  *";
            }
            System.out.println(rect);
        }
    }
}