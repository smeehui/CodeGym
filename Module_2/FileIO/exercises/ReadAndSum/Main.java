package ReadAndSum;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập đường dẫn file: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();

        Reader readfileEx = new Reader();
        readfileEx.readFileText(path);
    }
}
