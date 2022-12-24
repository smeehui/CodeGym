package CarRacing;

public class Main {
    public static final int DISTANCE = 100;
    public static final int STEP = 10;

    public static void main(String[] args) {
        RaceCar car1 = new RaceCar("TA's");
        RaceCar car2 = new RaceCar("QH's");
        RaceCar car3 = new RaceCar("TL's");

        Thread t1 = new Thread(car1);
        Thread t2 = new Thread(car2);
        Thread t3 = new Thread(car3);

        System.out.println("Distance: 100KM");
        t1.start();
        t2.start();
        t3.start();
    }
}
