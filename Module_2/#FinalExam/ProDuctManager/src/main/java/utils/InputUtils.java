package utils;

import java.util.Scanner;

public class InputUtils {
    private static InputUtils instance;
    private Scanner sc;

    private InputUtils() {
        sc = new Scanner(System.in);
    }

    ;

    public static InputUtils getInstance() {
        if (instance == null) instance = new InputUtils();
        return instance;
    }

    public int inputInteger(String field) {
        do {
            System.out.println("Nhập  "+field);
            String input = sc.nextLine();
            if (input.equals("#")) return -1;
            try {
                return Integer.parseInt(input);
            } catch (Exception e) {
                System.out.println("Nhập " + field + " không đúng định dạng");
            }
        } while (true);
    }
    public boolean isReturn(String value){
        return value.equals("-1") || value.equals("null") || value.equals("#");
    }

    public String inputString(String field) {
        System.out.println("Nhập "+field);
        String name = sc.nextLine();
        if (name.equals("#")) return null;
        return name;
    }

    public double inputDouble(String field) {
        do {
            System.out.println("Nhập "+field);
            String input = sc.nextLine();
            if (input.equals("#")) return  -1;
            try {
                return Double.parseDouble(input);
            } catch (Exception e) {
                System.out.println("Nhập " + field + " không đúng định dạng");
            }
        } while (true);
    }

    public long inputLong(String field) {
        do {
            System.out.println("Nhập "+field);
            String input = sc.nextLine();
            if (input.equals("#")) return  -1;
            try {
                return Long.parseLong(input);
            } catch (Exception e) {
                System.out.println("Nhập " + field + " không đúng định dạng");
            }
        } while (true);
    }

    public boolean confirmed(String field) {
        do{
            System.out.println("Xác nhận "+ field+"\n Nhập Y để đồng ý, nhập N để huỷ");
            String input = sc.nextLine();
            if(input.equals("Y")){
                return true;
            }
            else if(input.equals("N")){
                return false;
            }
            else System.out.println("Không đúng lựa chọn");
        }while (true);
    }
}

