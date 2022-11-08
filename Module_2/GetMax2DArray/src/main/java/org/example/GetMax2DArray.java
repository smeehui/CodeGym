package org.example;

public class GetMax2DArray {
    public static void main(String[] args) {
        System.out.println("Tìm phần tử lớn nhất mảng 2 chiều cho trước:");
        int[][] array = {{1, 2, 3, 4, 5}, {2, 3, 45, 2, 1, 3}, {23, 4, 5, 999, 3}, {2, 3, 4, 54, 5}};
        int[] result = getMax(array);
        System.out.println("Phần tử lớn nhất trong mảng là: " + result[0] + " ở vị trí [" + result[1] + ", " + result[2] + "]");
    }

    private static int[] getMax(int[][] array) {
        int max = array[0][0];
        int[] result = new int[3];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                    result[0] = max;
                    result[1] = i;
                    result[2] = j;
                }
            }
        }
        return result;
    }
}