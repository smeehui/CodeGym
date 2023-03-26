package code;

import code.abclass.Animal;
import code.inf.Flyable;

public class Bird extends Animal implements Flyable {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println( name + " Flying.....");
    }
}
