package CarRacing;

public abstract class Car {
    public Car() {}
    private String name;
    abstract public String getName();
    protected abstract String getNumber();
    public void go(){
        System.out.println("Go...");
    }
}
