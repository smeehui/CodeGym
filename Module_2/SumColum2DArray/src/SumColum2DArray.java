
import java.util.Scanner;

public class SumColum2DArray {
    public static void main(String[] args) {
        System.out.println("Nhập vào độ dài chiều dọc:");
        Scanner sc = new Scanner(System.in);
        int height = sc.nextInt();
        System.out.println("Nhập vào độ dài chiều ngang:");
        int width = sc.nextInt();
        double [][]array = createArray(width, height);
        displayArray(array);
        System.out.println("Nhập vào cột cần tính tổng (> 0):");
        int column = sc.nextInt();
        System.out.println("Tổng các giá trị của cột "+ column+ " là: "+ countColumns(column-1,array));
    }

    private static void displayArray(double[][] array) {
        System.out.println("Mảng đã nhập");
        StringBuilder row = new StringBuilder();
        for (double[] i:array){
            for (double j:i){
                row.append(j).append("   ");
            }
            row.append("\n");
        }
            System.out.println(row);
    }

    private static double countColumns(int column, double[][] array) {
        double sum =0;
        for (double[] doubles : array) {
            sum += doubles[column];
        }
        return sum;
    }

    private static double[][] createArray(int width, int height) {
        double [][] array = new double[width][height];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.println("Nhập vào giá trị phần tử thứ "+ (j+1) + " hàng "+ (i+1));
                array[i][j] = sc.nextDouble();
            }
        }
        return array;
    }
}