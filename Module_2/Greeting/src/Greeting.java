import java.util.Scanner;

public class Greeting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào tên của bạn:");
        String name = sc.nextLine();
        System.out.println("Xin chào: " + name);
    }
}