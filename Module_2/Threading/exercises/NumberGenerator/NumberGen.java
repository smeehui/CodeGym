package NumberGenerator;

import java.util.Objects;

public class NumberGen implements Runnable {
    private final String name;

    public NumberGen(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 1; i <=10;i++) {
            System.out.println(name+ ": " + i + " hash code: " + Objects.hashCode(this));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name +": "+ "Interrupted");
            }
        }
        System.out.println(name+ ": Done");
    }
}
