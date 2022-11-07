import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chiều cao: ");
        double height = sc.nextDouble();
        System.out.println("Nhập vào cân nặng: ");
        int weight = sc.nextInt();
        System.out.println("Chỉ số cơ thể BMI hiện tại của bạn là: " + calcBMI(height, weight));
    }

    private static String calcBMI(double height, int weight) {
        double BMI = weight / (height * height);
        boolean isTrue = true;
        if (BMI < 18.5) {
            return "Ốm";
        }
        if (BMI < 25.0) {
            return "Bình thường";
        }
        if (BMI < 30.0) {
            return "Mập";
        }
        return "Béo phì";
    }
}