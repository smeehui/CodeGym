package org.example;

public class MyClass {
    static  int X = 2;

    static {
        X = 1;
    }

    static public void method() {
        X = 5;
    }

    public static void main(String[] args) {
        MyClass o = new MyClass();
        MyClass.method();
        MyClass.X = 10;
        System.out.printf("x=%d, y=%d", o.X, MyClass.X);
    }
}
