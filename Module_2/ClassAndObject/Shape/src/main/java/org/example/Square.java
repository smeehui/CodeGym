package org.example;

/**
 *
 */
public class Square extends Rectangle {

    public Square() {
        setWidth(1);
        setWidth(1);
    }

    public Square(double side) {
        setWidth(side);
        setHeight(side);
    }
    public  Square(double side, String color, boolean isFilled) {
        setWidth(side);
        setHeight(side);
        setColor(color);
        setFilled(isFilled);
    }

    @Override
    public String toString() {
        return "A Square with side= "+getWidth()+", which is a subclass of "+ super.toString();
    }
}