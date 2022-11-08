package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println("Đảo ngược các phần tử của mảng");
        System.out.println("Nhập chiều dài mảng:");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] array = createArray(size);
        System.out.println("Mảng đã nhập là: " + Arrays.toString(array));
        int[] rvArray = reverseArray(array);
        System.out.println("Mảng đảo ngược là:" + Arrays.toString(rvArray));
    }

    private static int[] reverseArray(int[] array) {
        int size = array.length;
        int[] reverseArray = new int[size];
        for (int i = 0; i < size; i++) {
            reverseArray[i] = array[i];
        }
        for (int i = 0; i < size - i; i++) {
            int temp = reverseArray[i];
            reverseArray[i] = reverseArray[size - 1 - i];
            reverseArray[size - 1 - i] = temp;
        }
        return reverseArray;
    }

    private static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Nhập giá trị thứ " + (i + 1) + " của mảng:");
            Scanner sc = new Scanner(System.in);
            array[i] = sc.nextInt();
        }
        return array;
    }
}