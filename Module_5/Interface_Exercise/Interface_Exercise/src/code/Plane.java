package code;

import code.abclass.Machine;
import code.inf.Flyable;

public class Plane extends Machine implements Flyable {
    public Plane(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println( name + "Flying.....");
    }
}
