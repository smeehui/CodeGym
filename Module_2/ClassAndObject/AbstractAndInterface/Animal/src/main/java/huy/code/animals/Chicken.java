package huy.code.animals;

import huy.code.Animal.Animal;
import huy.code.edible.Edible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: quark quark";
    }

    @Override
    public String howToEat() {
        return "Chicken: Boil";
    }
}
