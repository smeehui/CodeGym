package org.example;

import java.util.Scanner;

public class GetMax {
    public static void main(String[] args) {
        System.out.println("Nhập số lượng phần tử của danh sách");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = createArray(size);
        int[] result = getMax(array);
        System.out.println("Phần tử lớn nhất trong mảng là: " + result[0] + " ở vị trí "+ (result[1] +1));
    }

    private static int[] getMax(int[] array) {
        int max = array[0];
        int [] result = new int[2];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                result[0]= max;
                result[1]= i;
            }
        }
        return result;
    }

    private static int[] createArray(int size) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.println("Nhập giá trị phần tử thứ " + (i + 1));

            array[i] = sc.nextInt();
        }
        return array;
    }
}