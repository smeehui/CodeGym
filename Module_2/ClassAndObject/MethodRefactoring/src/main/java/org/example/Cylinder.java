package org.example;

public class Cylinder {
    public static double getVolume(int radius, int height){
        return getBasePerimeter(radius) * height + 2 * getBaseArea(radius);
    }
    public static double getBaseArea(int radius){
        return Math.PI * radius * radius;
    }
    public static double getBasePerimeter(int radius){
        return 2 * Math.PI  * radius;
    }
}
