import java.util.Scanner;

public class FirstDegEquation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Giải phương trình bậc nhất");
        System.out.println("Nhập a: ");
        double a = sc.nextDouble();
        System.out.println("Nhập b: ");
        double b = sc.nextDouble();
        System.out.println(calc(a,b));;
    }

    private static String calc(double a, double b) {
        String result = "";
        if (a==0){
            if(b==0) {
                result = "Phương trình có vô số nghiệm";
            }
            else result = "Phương trình vô nghiệm";
        }else result ="Phương trình có nghiệm " + -b/a;
        return result;
    }
}