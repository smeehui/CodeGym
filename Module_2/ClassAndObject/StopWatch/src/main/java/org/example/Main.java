package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        StopWatch watch = new StopWatch();

        watch.start();
//        Scanner sc = new Scanner(System.in);
//        int selection;
//        do {
//            System.out.println("Watch started, type 0 to stop!");
//            selection = sc.nextInt();
//        } while (selection != 0);
        Thread.sleep(5000);
        watch.end();
        System.out.println("Elapsed time: " + watch.getElapsedTime() + " millis seconds");
    }
}