package org.example;

import java.util.Arrays;

public class Point {

    private float x = 0.0f;
    private float y = 0.0f;
    private float[] XY = new float[2];

    public Point() {
    }

    public Point(float x, float y) {
        this.setX(x);
        this.setY(y);
        this.setXY(this.getX(), this.getY());
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float[] getXY() {
        return this.XY;
    }

    public void setXY(float x, float y) {
        this.XY[0] = x;
        this.XY[1] = y;
    }

    public String toString() {
        return "2D coordinates: " + Arrays.toString(this.getXY());
    }
}