package org.huycode;

import java.util.Scanner;

public class GetInterest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số tiền vay:");
        int sent = sc.nextInt();
        System.out.println("Nhập tỉ lệ lãi suất theo tháng (% năm):");
        double monthlyInterest = sc.nextDouble();
        System.out.println("Nhập số tháng vay:");
        int months = sc.nextInt();
        System.out.println("Số tiền lãi của bạn sau " + months + " tháng là: " + calcInterest(sent, monthlyInterest, months));
    }

    private static double calcInterest(int sent, double monthlyInterest, int months) {
        return sent * (monthlyInterest/100) / 12 * months;
    }
}