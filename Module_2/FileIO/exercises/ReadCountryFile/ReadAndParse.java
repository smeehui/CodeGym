package ReadCountryFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;


public class ReadAndParse {
    public List<String> readFile(String path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();
            return lines;
        } catch (Exception e) {
            System.out.println("Có lỗi");
        }
        return null;
    }

    public String parse(List<String> lines) {
        StringBuilder sb = new StringBuilder();
        for (String line : lines) {
            sb.append(String.format("%3s\t%-10s%-15s",line.split(","))).append("\n");
        }
        return sb.toString();
    }
}
