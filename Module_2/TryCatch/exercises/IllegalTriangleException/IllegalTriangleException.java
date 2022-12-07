package IllegalTriangleException;

public class IllegalTriangleException extends Exception{
    @Override
    public String getMessage() {
        return "IllegalTriangleSideValues";
    }
}
