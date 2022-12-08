package FileIOStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileOutPutStreamEx {
    public static void main(String[] args) {
        try (FileOutputStream fo = new FileOutputStream("./data/fos.zip")) {
            String rawData = FileInputStreamEx.read("./data/src.zip");
            byte[] bytes = rawData.getBytes(Charset.defaultCharset());
            fo.write(bytes,0,bytes.length);
            System.out.println(FileInputStreamEx.read("./data/fos.zip"));
            System.out.println("--------------------------------");
            System.out.println(FileInputStreamEx.read("./data/src.zip"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
