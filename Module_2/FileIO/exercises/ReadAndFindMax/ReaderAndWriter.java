package ReadAndFindMax;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class ReaderAndWriter {
    private final List<Integer>  integerList = new ArrayList<>();
    public ReaderAndWriter(){
    }
    public void readFile(String path){
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null){
                addToList(line);
                br.readLine();
            }
            br.close();
        } catch (Exception e) {
            System.out.println("File not found or data incorrect");
        }
    }
    public void writeToFile(String path,String value){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path));
            writer.write(value);
            writer.close();
        } catch (IOException e) {
            System.out.println("Wrong path");
        }
    }

    private void addToList(String line) {
        integerList.add(Integer.parseInt(line));
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }
}
