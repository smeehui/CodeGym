package org.example;

public class GetMinIndex {
    public static void main(String[] args) {
        int[] arr = {3,6,7,4,5,2,32,12};
        int index = getMinValueIndex(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }

    public static int getMinValueIndex(int[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }
}