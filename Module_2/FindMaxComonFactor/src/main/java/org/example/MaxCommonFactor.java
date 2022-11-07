package org.example;

import java.util.Scanner;

public class MaxCommonFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số thứ nhất:");
        int a = sc.nextInt();
        System.out.println("Nhập vào số thứ hai:");
        int b = sc.nextInt();
        int maxCommonFactor = getMaxCommonFactor(a, b);
        if (maxCommonFactor == 0) System.out.println("Không có ước chung lớn nhất");
        else System.out.println("Ước chung lớn nhất là " + maxCommonFactor);
    }

    private static int getMaxCommonFactor(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0) {
            return 0;
        }
        while (a != b) {
            if (a > b) a -= b;
            else b -= a;
        }
        return a;
    }
}