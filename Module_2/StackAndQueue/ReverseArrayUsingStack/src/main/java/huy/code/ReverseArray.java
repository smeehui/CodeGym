package huy.code;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,0};
        Stack<Integer> stack = new Stack<Integer>();
        System.out.println(Arrays.toString(arr));
        for (int i : arr) {
                stack.push(i);
            }
        int[] reverseArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reverseArray[i]=stack.pop();
            }
        System.out.println(Arrays.toString(reverseArray));
    }
}