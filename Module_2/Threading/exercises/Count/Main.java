package Count;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread started");
        Count count1 = new Count("Thread 1");
        Count count2 = new Count("Thread 2");
        Count count3 = new Count("Thread 3");
        Thread t1 = new Thread(count1);
        Thread t2 = new Thread(count2);
        Thread t3 = new Thread(count3);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main thread ended");
    }
}
