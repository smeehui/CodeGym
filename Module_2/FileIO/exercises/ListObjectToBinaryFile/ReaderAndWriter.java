package ListObjectToBinaryFile;

import java.io.*;
import java.util.Collections;
import java.util.List;

public class ReaderAndWriter {
    public List<Student> readFromFile(String path) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            List<Student> students = (List<Student>) ois.readObject();
            ois.close();
            return students;
        } catch (IOException e) {
            System.out.println("Error reading from file " + path);
            return Collections.emptyList();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean writeToFile(String path, List<Student> students) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(students);
            oos.close();
            return true;
        } catch (IOException e) {
            System.out.println("Failed to write");
            return  false;
        }
    }
}
