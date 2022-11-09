package org.example;

import java.util.Objects;
import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        String str = "Viverra propriae eius iaculis iuvaret vivendo comprehensam prompta";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ký tự cần đếm:");
        char letter = sc.next().charAt(0);
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (Objects.equals(str.charAt(i), letter)) count++;
        }
        System.out.println("Số lần xuất hiện của ký tự " + letter +" là: "+ count);

    }
}