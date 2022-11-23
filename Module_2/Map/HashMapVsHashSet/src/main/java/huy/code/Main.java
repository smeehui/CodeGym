package huy.code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Huy", 23, "Hue");
        Student student2 = new Student("Phat", 25, "Hue");
        Student student3 = new Student("Phuoc", 26, "Hue");
        Student student4 = new Student("Anh", 27, "Hue");
        HashMap<Integer, Student> students = new HashMap<>();
        students.put(1, student1);
        students.put(2, student2);
        students.put(3, student3);
        students.put(4, student4);
        System.out.println("HashMap");
        students.forEach((k, v) -> System.out.println(k + " = " + v));
        HashSet<Student> studentsHS = new HashSet<>();
        studentsHS.add(student1);
        studentsHS.add(student2);
        studentsHS.add(student3);
        studentsHS.add(student4);
        System.out.println();
        System.out.println("HashSet");
        AtomicInteger count= new AtomicInteger();
        studentsHS.forEach((student)-> {
            count.getAndIncrement();
            System.out.println(count+ " : " + student);
        });
    }
}