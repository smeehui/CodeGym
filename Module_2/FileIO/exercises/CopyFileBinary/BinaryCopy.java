package CopyFileBinary;

import java.io.*;

public class BinaryCopy {
    public static void copy(String src, String dest){
        InputStream is;
        OutputStream os;
    try {
            os = new FileOutputStream(dest,true);
            is = new FileInputStream(src);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) > 0) {
                os.write(buffer, 0, len);
            }
            is.close();
            os.close();
        System.out.println("Copy done");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
