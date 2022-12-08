package FileIOProductMgr;

import FileObjectIOS.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class FOIStream {
    public static List<Product> read(String path) {
        try (ObjectInputStream oip = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Product>) oip.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
