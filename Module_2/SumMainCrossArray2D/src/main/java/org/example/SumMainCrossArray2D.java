package org.example;

import java.util.Scanner;

public class SumMainCrossArray2D {
    public static void main(String[] args) {
        System.out.println("Nhập vào độ dài chiều dọc:");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        System.out.println("Nhập vào độ dài chiều ngang:");
        int width = sc.nextInt();
        double [][]array = createArray(width, height);
        displayArray(array);
        System.out.println("Tổng các giá trị đường chéo chính là: "+ sumMainCross(array));
    }

    private static void displayArray(double[][] array) {
        System.out.println("Mảng đã nhập");
        StringBuilder row = new StringBuilder();
        for (double[] i:array){
            for (double j:i){
                row.append(j).append("   ");
            }
            row.append("\n\n");
        }
        System.out.println(row);
    }

    private static double sumMainCross(double[][] array) {
        double sum =0;
        for (int i = 0; i < array.length; i++) {
                sum += array[i][i];
        }
        return sum;
    }

    private static double[][] createArray(int width, int height) {
        double [][] array = new double[width][height];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.println("Nhập vào giá trị phần tử thứ "+ (j+1) + " hàng "+ (i+1));
                array[i][j] = sc.nextDouble();
            }
        }
        return array;
    }
}