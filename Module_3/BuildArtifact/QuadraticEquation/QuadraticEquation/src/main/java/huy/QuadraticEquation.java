package huy;


public class QuadraticEquation {
    public static void main(String[] args) {

    }
    public static String calculate(double a, double b, double c) {
        if (a == 0) return calculateMostEquation(b,c);
        double delta = calculateDelta(a, b, c);
        if (delta<0) return "PT vô nghiêm";
        if (delta==0) return  "PT có nghiệm kép x1 = x2 = " + calculateDoubleEquation(b, a);
        double[] equations = calculateTwoDiffEquation(delta, a, b);
        return "PT có nghiệm phân biệt: x1 = " + equations[0] + ", x2 = " + equations[1];
    }

    private static double[] calculateTwoDiffEquation(double delta, double a, double b) {
        double x1 = (-b - Math.sqrt(delta)) / (2 * a);
        double x2 = (-b + Math.sqrt(delta)) / (2 * a);
        return new double[]{x1, x2};
    }

    private static double calculateDoubleEquation(double b, double a) {
        return -b / (2 * a);
    }

    public static double calculateDelta(double a, double b, double c) {
        return b * b - 4 * a * c;
    }

    public static String calculateMostEquation(double b, double c) {
        if (b == 0 && c != 0) return "PT Vô nghiệm";
        if (b == 0) return "PT vô số nghiệm";
        else return "PT có nghiệm x = " + (-c / b);
    }
}