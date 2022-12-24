package huy.linkedListStack;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyLinkedListStack<String> stringStack= new MyLinkedListStack<>();
        System.out.println(stringStack);
        stringStack.push("Hello");
        stringStack.push("My");
        stringStack.push("Name's");
        stringStack.push("Huy");
        System.out.println(stringStack);
        System.out.println();
        System.out.println("Pop");
        System.out.println(stringStack.pop());
        System.out.println(stringStack.pop());
        System.out.println(stringStack);
        System.out.println();
        System.out.println("Peek");
        System.out.println(stringStack.peek());
        System.out.println();
        System.out.println("To array");
        System.out.println(Arrays.toString(stringStack.toArray()));

        System.out.println();
        MyLinkedListStack<String> ndStack = new MyLinkedListStack<>("love");
        System.out.println(ndStack);
        ndStack.push("Hello");
        ndStack.push("World");
        System.out.println(ndStack);
        ndStack.pop();
        ndStack.pop();
        ndStack.pop();
        System.out.println(ndStack);
        System.out.println();
        System.out.println();
        MyLinkedListStack<Integer> intergerStack = new MyLinkedListStack<>(0);
        intergerStack.push(1);
        intergerStack.push(2);
        System.out.println(Arrays.toString(intergerStack.toArray()));
    }
}