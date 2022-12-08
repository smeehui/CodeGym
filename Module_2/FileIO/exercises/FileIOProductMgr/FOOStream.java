package FileIOProductMgr;

import FileObjectIOS.Person;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FOOStream {
    public static void write(String path, List<Product> products) {
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream(path))) {
            oop.writeObject(products);
            oop.flush();
            oop.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
