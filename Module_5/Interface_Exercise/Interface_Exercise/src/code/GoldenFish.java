package code;

import code.abclass.Animal;
import code.inf.Swimmable;

public class GoldenFish extends Animal implements Swimmable {
    public GoldenFish(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + " Swimm.....");
    }
}
