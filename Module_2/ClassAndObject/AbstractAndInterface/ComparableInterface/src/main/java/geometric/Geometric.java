package geometric;

public abstract class Geometric {
    private String color = "black";
    private boolean isFilled = false;

    public Geometric() {
    }

    public Geometric(String color, boolean isFilled) {
        this.setColor(color);
        this.setFilled(isFilled);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }

    public abstract double getArea();

    public abstract double getPerimeter();
}
