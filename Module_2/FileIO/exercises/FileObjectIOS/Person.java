package FileObjectIOS;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    public String name;
    private String address;

    public Person(int age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
               "age=" + age +
               ", name='" + name + '\'' +
               ", address='" + address + '\'' +
               '}';
    }
}
