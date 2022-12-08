package ListObjectToBinaryFile;

import java.util.ArrayList;
import java.util.List;

public class StudentMgr {
    public static void main(String[] args) {
        ReaderAndWriter readerAndWriter = new ReaderAndWriter();
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1, "Vũ Kiều Anh", "Hà Nội"));
        students.add(new Student(2, "Nguyễn Minh Quân", "Hà Nội"));
        students.add(new Student(3, "Đặng Huy Hoà", "Đà Nẵng"));
        students.add(new Student(4, "Nguyễn Khánh Tùng", "Hà Nội"));
        students.add(new Student(5, "Nguyễn Khắc Nhật", "Hà Nội"));
        boolean status = readerAndWriter.writeToFile("./data/students.csv", students);
        System.out.println(status ? "Success" : "Failed");



        List<Student> readStudents = readerAndWriter.readFromFile("./data/students.csv");
        for (Student student : readStudents) {
            System.out.println(student);
        }
    }
}
