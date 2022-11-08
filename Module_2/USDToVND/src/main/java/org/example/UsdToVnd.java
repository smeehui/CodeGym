package org.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class UsdToVnd {
    public static void main(String[] args) {
        System.out.println("Nhập vào số tiền USD cần đổi");
        Scanner sc = new Scanner(System.in);
        double usd = sc.nextDouble();
        Locale usLocale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(usLocale);
        String usdString = currencyFormatter.format(usd);
        System.out.println(usdString +" bằng " + convertToVnd(usd));
    }

    private static String convertToVnd(double usd) {
        Locale viLocale = new Locale("vi", "VN");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(viLocale);
        return currencyFormatter.format(usd * 23000);
    }
}