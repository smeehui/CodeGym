package OddEvenPrint;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main started");
        Thread odd = new Thread(new OddThread());
        Thread even = new Thread(new EvenThread());
        odd.start();
        odd.notify();
//        try {
//            odd.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        even.start();
        System.out.println("Main ended");
    }
}
