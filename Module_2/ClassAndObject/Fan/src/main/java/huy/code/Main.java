package huy.code;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        fan1.setSpeed(Fan.SLOW);
        fan1.setOn(true);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        System.out.println("fan 1: " + fan1);
        System.out.println("------------------------------------------------------------------");
        Fan fan2 = new Fan();
        fan2.setSpeed(Fan.FAST);
        fan2.setOn(false);
        fan2.setRadius(5);
        fan2.setColor("blue");
        System.out.println("fan 2: " + fan2);
    }
}