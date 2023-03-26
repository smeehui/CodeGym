package code;

import code.abclass.Animal;
import code.inf.Barkable;
import code.inf.Flyable;
import code.inf.Swimmable;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("dog");
        Car car = new Car("car");
        Bird bird = new Bird("Bird");
        GoldenFish goldenFish = new GoldenFish("Golden Fish");
        Plane plane = new Plane("Plane");

        action(dog, car, bird, goldenFish, plane);
    }
    public static void action(Object ...objs) {

        for (Object obj : objs) {
            if (obj instanceof Swimmable)
                ((Swimmable) obj).swim();

            if (obj instanceof Flyable)
                ((Flyable) obj).fly();

            if (obj instanceof Runnable)
                ((Runnable) obj).run();

            if (obj instanceof Barkable)
                ((Barkable) obj).bark();

        }
    }
}
