package utils;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    private  static  FileUtils instance;
    private FileUtils(){}
    public  static  FileUtils getInstance() {
        if (instance == null) instance = new FileUtils();
        return instance;
    }

    public List<Product> readFile(String path) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            List<Product> list = new ArrayList<>();
            while ((line = br.readLine())!= null) {
                list.add(Product.parse(line));
            }
            br.close();
            return list;

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void write(String path,List<Product> products) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(path));
            for (Product product : products) {
                bw.write(product.toString()+"\n");
            }
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
