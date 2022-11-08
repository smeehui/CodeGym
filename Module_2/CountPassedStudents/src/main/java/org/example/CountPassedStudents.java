package org.example;

import java.util.Scanner;

public class CountPassedStudents {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập độ dài danh sách");
            size = sc.nextInt();
            if (size > 30)
                System.out.println("Độ dài danh sách không được vượt quá 30");
        } while (size > 30);
        array = createArray(size);
        int count = countPassedStudents(array);

        System.out.println("Số lượng học sinh vượt qua là: " + count);
    }

    private static int countPassedStudents(int[] array) {
        int count = 0;
        System.out.println("Danh sách điểm: ");
        for (int i : array) {
            System.out.print(i + "\t");
            if (i >= 5 && i <= 10)
                count++;
        }
        return count;
    }

    private static int[] createArray(int size) {
        Scanner sc = new Scanner(System.in);
        int i = 0;
        int[] array = new int[size];
        while (i < array.length) {
            do {
                System.out.println("Nhập điểm cho sinh viên thứ " + (i + 1) + ": ");
                array[i] = sc.nextInt();
            } while(array[i]<0||array[i]>10);
            i++;
        }
        return  array;
    }
}