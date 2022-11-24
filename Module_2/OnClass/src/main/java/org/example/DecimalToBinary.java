package org.example;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Stack;

public class DecimalToBinary {
    public static void main(String[] args) {
        int number = 5;
        Stack<Integer> stack = new Stack<Integer>();
        int division = number;
       do{
           stack.push(division%2);
           division=division/2;
       } while (division!=0);
       int[] array = new int[stack.size()];
       int counter = 0;
       while (!stack.isEmpty()){
           array[counter] = stack.pop();
           counter++;
       }
       System.out.println(Arrays.toString(array));
    }
}
