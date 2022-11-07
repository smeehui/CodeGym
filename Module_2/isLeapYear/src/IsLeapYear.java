import java.util.Scanner;

public class IsLeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào năm:");
        int year = sc.nextInt();
        boolean isLeapYear =isLeapYear(year);
        if (isLeapYear) System.out.println(year + " là năm nhuận");
        else System.out.println(year + " Không phải là năm nhuận");
    }

    private static boolean isLeapYear(int year) {
        if(year%4==0){
            if(year%100!=0) return true;
            if (year%400==0) return true;
        }
        return false;
    }
}