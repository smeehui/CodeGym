package FileObjectIOS;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FOOStream {
    public static void main(String[] args) {
        Person person = new Person(20,"Huy","HUE");
        try (ObjectOutputStream oop = new ObjectOutputStream(new FileOutputStream("./data/person.txt"))) {
            oop.writeObject(person);
            oop.flush();
            oop.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
