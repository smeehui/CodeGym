package org.example;

import java.util.Arrays;

public class ConcatArray {
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6};
        int[] array2 = {7,8,9,10,11};
        System.out.println("Nối hai mảng cho trước.");
        System.out.print("Mảng 1" + Arrays.toString(array1) + " ----- ");
        System.out.println("Mảng 2" + Arrays.toString(array2));
        System.out.println("Mảng đã nối là: " + Arrays.toString(concat(array1,array2)));
    }

    private static int[] concat(int[] array1, int[] array2) {
        int [] newArr = new int[array1.length + array2.length];
        for (int i = 0; i <array1.length; i++) {
            newArr[i] = array1[i];
        }
        for (int i = 0; i < array2.length; i++){
            newArr[array1.length+i] = array2[i];
        }
    return newArr;
    }
}