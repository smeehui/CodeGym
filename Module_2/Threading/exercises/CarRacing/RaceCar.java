package CarRacing;

import java.util.Random;

public class RaceCar implements Runnable {
    private final String  name;

    public RaceCar(String name) {
        this.name = name;
    }

    @Override
    public void run() {
//        int runDistance = 0;
//        long startTime = System.currentTimeMillis();
//        while (runDistance < Main.DISTANCE) {
//            try{
//                int speed = (new Random()).nextInt(10);
//                runDistance+=speed;
//                String log = "|";
//                int percentTravel = (runDistance*100)/Main.DISTANCE;
//                for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
//                    if (percentTravel >= i + Main.STEP) {
//                        log += "=";
//                    } else if (percentTravel >= i && percentTravel < i + Main.STEP) {
//                        log += "o";
//                    } else {
//                        log += "-";
//                    }
//                }
//                log += "|";
//                System.out.println("Car " + this.name + ": " + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Broken...");
//            }
//        }
//        long endTime = System.currentTimeMillis();
//        System.out.println("Car " + this.name + " Finish in " + (endTime - startTime) / 1000 + "s");
        int runDistance = 0;
        long startTime = System.currentTimeMillis();
        while (runDistance < Main.DISTANCE) {
            int speed = (new Random()).nextInt(10);
            runDistance += speed;
            int percentTravel = runDistance * 100 / Main.DISTANCE;
            StringBuilder log = new StringBuilder("|");
            for (int i = 0; i < Main.DISTANCE; i += Main.STEP) {
                if (percentTravel >= i + Main.STEP) log.append("=");
                else if (percentTravel >= i && percentTravel < i+ Main.STEP) log.append("0");
                else log.append("-");
            }
            log.append("|");
            System.out.println("Car " + this.name + ": " + log + " " + Math.min(Main.DISTANCE, runDistance) + "KM");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Broken...");
            }
        }
        System.out.println(this.name + ": " + "finished in" + (System.currentTimeMillis() - startTime)/1000 + "s");
    }
}
