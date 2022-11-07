package org.example;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        System.out.println("Nhập vào một số:");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(isPrime(number)) System.out.println(number+ " Là số nguyên tố");
        else System.out.println(number + " không phải là số nguyên tố");
    }

    private static boolean isPrime(int number) {
        boolean check = true;
        if (number<2) return check=false;
        int count= 2;
        while (count<Math.sqrt(number)){
            if(number%count==0) check = false;
            count++;
        }
        return check;
    }
}