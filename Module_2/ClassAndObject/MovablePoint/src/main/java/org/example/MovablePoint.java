package org.example;

import java.util.Arrays;

public class MovablePoint extends Point {

    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    private float[] speed = new float[2];

    public MovablePoint() {
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x,y);
        this.setxSpeed(xSpeed);
        this.setySpeed(ySpeed);
        this.setSpeed(this.getxSpeed(),this.getySpeed());
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return this.speed;
    }

    public void setSpeed(float xSpeed,float ySpeed){
        this.speed[0] = xSpeed;
        this.speed[1] = ySpeed;
    }
    public MovablePoint move(){
        return new MovablePoint(getX()+this.getxSpeed(), getY()+ this.getySpeed(),this.getxSpeed(), this.getySpeed());
    }
     public String toString() {
        // TODO implement here
        return Arrays.toString(getXY())+", speed "+ Arrays.toString(this.getSpeed());
    }

}