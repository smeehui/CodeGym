package FileObjectIOS;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FOIStream {
    public static void main(String[] args) {
        try (ObjectInputStream oip = new ObjectInputStream(new FileInputStream("./data/person.txt"))) {
            Person person = (Person) oip.readObject();
            System.out.println(person);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
