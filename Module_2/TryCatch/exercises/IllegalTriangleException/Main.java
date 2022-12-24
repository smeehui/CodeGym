package IllegalTriangleException;

public class Main {
    public static void main(String[] args) {
        try {
            Triangle triangle = new Triangle(1,1,5);
            System.out.println(triangle);
        } catch (IllegalTriangleException e) {
            System.out.println(e.getMessage());
        }
    }
}
