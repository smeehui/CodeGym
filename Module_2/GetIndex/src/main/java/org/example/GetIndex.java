package org.example;

import java.util.Scanner;

public class GetIndex {
    public static void main(String[] args) {
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor", "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.println("Nhập tên sinh viên để tìm kiếm");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        int index = getIndex(name, students);
        if (index == -1) System.out.println("Không có thông tin");
        else System.out.println("Vị trí của " + name + " trong danh sách là: " + (getIndex(name, students) + 1));
    }

    private static int getIndex(String name, String[] students) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(name)) {
                index = i;
                break;
            }

        }
        return index;
    }
}