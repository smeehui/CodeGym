package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveArrayElement {
    public static void main(String[] args) {
        int [] array = {1,2,3};
        System.out.println("Nhập giá trị phần tử muốn xoá:");
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int [] rmArr = checkElement(value,array);
        if (rmArr.length == 0) System.out.println("Không tìm thấy giá trị đã nhập");
        else System.out.println("Mảng sau khi xoá: " + Arrays.toString(rmArr));
    }

    private static int[] checkElement(int value, int[] array) {
        int[] newArr = new int[array.length];
        System.arraycopy(array, 0, newArr, 0, array.length);
        int [] result = new int[0];
        for (int i=0;i<array.length;i++) {
            if (array[i] == value) {
                result = removeElement(i,newArr);
                break;
            }
        }
        System.out.println("Mảng trước khi xoá: " + Arrays.toString(array));
        return result;
    }

    private static int[] removeElement(int i, int[] array) {
           for (int j =i;j<=array.length-1;j++){
               if(i==array.length-1) array[i]=0;
               else array[j]=array[j+1];
           }
        return array;
    }
}