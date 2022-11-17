package circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    public ComparableCircle() {
        super();
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public int compareTo(ComparableCircle circle) {
//        return Double.compare(this.getRadius(), circle.getRadius()); Java double compare
        if (this.getRadius() > circle.getRadius()) return 1;
        if (this.getRadius() == circle.getRadius()) return 0;
        return -1;
    }
}
