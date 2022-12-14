package Count;

public class Count implements Runnable{
    private final String name;

    public Count(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(name+": "+name +" count to: " + (i+1));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(name+": Interrupted");
            }
        }
        System.out.println(name+": Done");
    }
}
