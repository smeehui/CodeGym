package CopyFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileIO {
    public List<String> readFile(String path){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();
            return lines;
        } catch (Exception e) {
            System.out.println("File không tìm thấy.");
        }
        return null;
    }

    public void writeFile(String path, List<String> lines) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            for (String line : lines) {
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("File bị lỗi");
        }
    }
}
