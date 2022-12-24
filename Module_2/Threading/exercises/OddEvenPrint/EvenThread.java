package OddEvenPrint;

public class EvenThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i += 2) {
            System.out.println("Even: " + i);
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                System.out.println("Even interrupted");
            }
        }
        System.out.println("Even ended");
    }
}
