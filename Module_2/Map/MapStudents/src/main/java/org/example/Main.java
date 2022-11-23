package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> students = new HashMap<>();
        students.put("Sarah", 22);
        students.put("Anh", 20);
        students.put("Jack", 19);
        students.put("Huy", 23);
        students.put("Toan", 20);
        students.put("Phat", 25);
        students.put("Phuoc", 27);
        System.out.println(students);
        TreeMap<String, Integer> sortedStudents = new TreeMap<>(students);
        System.out.println(sortedStudents);
        LinkedHashMap<String, Integer> displayStudents = new LinkedHashMap<>(sortedStudents);
        System.out.println("Tuoi cua Huy: " + displayStudents.get("Huy"));
        System.out.println("Tuoi cua Phat: " + displayStudents.get("Phat"));
        System.out.println("Tuoi cua Anh: " + displayStudents.get("Anh"));
    }
}