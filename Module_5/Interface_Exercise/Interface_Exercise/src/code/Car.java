package code;

import code.abclass.Machine;

public class Car extends Machine implements Runnable {

    public Car(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(name + " Running ....");
    }
}
