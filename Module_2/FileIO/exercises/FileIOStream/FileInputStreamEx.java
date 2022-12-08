package FileIOStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {
    public static String read(String path) {
        try {
            FileInputStream fi = new FileInputStream(path);
            int i;
            byte[] bytes = new byte[2048];
            StringBuilder sb = new StringBuilder();
            while ((i=fi.read(bytes))!=-1){
                String str = new String(bytes,0,i);
                sb.append(str);
            }
            fi.close();
            return sb.toString();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
