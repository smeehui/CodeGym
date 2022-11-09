package huy.code;

public class Fan {
    protected static final int SLOW = 1;
    protected static final int MEDIUM = 2;
    protected static final int FAST = 3;
    private int speed = SLOW;
    private boolean isOn = false;
    private double radius = 5;
    private String color = "blue";

    Fan() {
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return "Speed: "+ speed + ", "+"on: " + isOn + ", radius: "+ this.radius +", color: "+ this.color;
    }
}
