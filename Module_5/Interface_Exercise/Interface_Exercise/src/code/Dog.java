package code;

import code.abclass.Animal;
import code.inf.Barkable;

public class Dog extends Animal implements Barkable,Runnable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void bark() {
        System.out.println(name + " Barking....");
    }

    @Override
    public void run() {
        System.out.println(name + " Running....");
    }
}
