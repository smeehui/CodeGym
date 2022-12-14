package MultiThreadDemo;

public class RunableDemo implements Runnable {
    private final String name;
    private Thread thread;

    public RunableDemo(String name) {
        this.name = name;
        System.out.println("Thread " + name + " creating...");
    }

    @Override
    public void run() {
        System.out.println("Running thread "+name);
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread "+name +" "+i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + "is interrupted");
        }
        System.out.println("Thread " + name + " done");
    }
    public void start(){
        System.out.println("Starting thread "+name);
        if (thread==null) {
            thread = new Thread(this,name);
            thread.start();
        }
    }
}
