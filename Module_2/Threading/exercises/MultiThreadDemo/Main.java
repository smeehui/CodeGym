package MultiThreadDemo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main thread is running...");
        RunableDemo thread1 = new RunableDemo("Thread-1-HR-Database");
        thread1.start();
        RunableDemo thread2 = new RunableDemo("Thread-2-Send-Email");
        thread2.start();
        System.out.println("Main thread is stopped");
    }
}
