package huy.code;

import java.util.Arrays;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello world! I'm Huy";
        String[] strArr = str.split("");
        Stack<String> stack = new Stack<>();
        System.out.println(str);
        for (String i : strArr) {
            stack.push(i);
        }
        String[] reverseArray = new String[strArr.length];
        StringBuilder reverseString = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            reverseArray[i]=stack.pop();
            reverseString.append(reverseArray[i]);
        }
        System.out.println(reverseString);
    }
}
