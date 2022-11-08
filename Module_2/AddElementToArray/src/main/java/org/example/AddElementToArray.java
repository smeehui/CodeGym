package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementToArray {
    public static void main(String[] args) {
        int[] array;
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println("Nhập số cần chèn vào mảng:");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int index;
        do {
            System.out.println("Nhập vào chỉ mục cần chèn:");
            index = sc.nextInt();
            if (index <= -1 || index >= array.length - 1) System.out.println("Chỉ mục không hợp lệ");
        } while (index <= -1 || index > array.length);
        System.out.println("Mảng sau khi thêm: " + Arrays.toString(addElementToArray(value, index, array)));
    }

    private static int[] addElementToArray(int value, int index, int[] array) {
        int[] newArr = new int[array.length + 1];
        System.arraycopy(array, 0, newArr, 0, array.length);
        newArr[index] = value;
        for (int i = 0; i < newArr.length; i++) {
            if (i < index) newArr[i] = array[i];
            else if (i == index) newArr[i] = value;
            else newArr[i] = array[i - 1];

        }
        System.out.println("Mảng trước khi thêm: " + Arrays.toString(array));
        return newArr;
    }
}