import java.util.Scanner;

public class GetDayNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tháng: ");
        int month = sc.nextInt();
        int days = getDayNumber(month);
        boolean isValid = (days != 0);
        if (isValid) {
            System.out.println("Số ngày trong tháng là: " + days);
        }
    }

    private static int getDayNumber(int month) {
        switch (month) {
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return 28;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            default:
                System.out.println("Tháng không hợp lệ");
                return 0;
        }
    }
}