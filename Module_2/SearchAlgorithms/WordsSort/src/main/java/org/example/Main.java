package org.example;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) {
        String str = "Hello world!";
        ArrayDeque<Character> queue = new ArrayDeque<>();
        queue.add(str.charAt(0));
        for (int i = 1; i <str.length()-1;i++) {
            if(str.charAt(i)>queue.getLast()) queue.add(str.charAt(i));
        }
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            System.out.print(queue.poll());
        }
    }
}