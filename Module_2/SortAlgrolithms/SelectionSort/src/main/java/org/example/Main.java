package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[scanner.nextInt()];
        for (int i= 0; i <numbers.length; i++)
        {
            numbers[i] = (int) (Math.random() * 90 + 10);
        }
//        selectionLoopSort(numbers);
        selectionRecursiveSort(numbers, 0);
        System.out.println(Arrays.toString(numbers));
    }

    private static int[] selectionRecursiveSort(int[] numbers, int loops) {
        if (loops == numbers.length - 1) return numbers;
        else {
            int min = numbers[loops];
            for (int i = loops; i < numbers.length; i++) {
                if (min > numbers[i]) {
                    numbers[loops] = numbers[i];
                    numbers[i] = min;
                    min = numbers[loops];
                }
            }
            return selectionRecursiveSort(numbers, loops + 1);
        }
    }

    private static void selectionLoopSort(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] < numbers[i]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}