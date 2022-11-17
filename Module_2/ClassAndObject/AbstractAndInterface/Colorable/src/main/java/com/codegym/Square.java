package com.huy;

import colorable.Colorable;

public class Square extends Rectangle implements Colorable {
    public Square() {

    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean isFilled) {
        super(side, side, color, isFilled);
    }

    public String howToColor() {
        return "Color all four side";
    }
}
