package huy.code;

public class Main {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        for (Object element :  myList.getAll()) {
            System.out.println(element);
        }
        System.out.println("--------------------------------\nAfter remove");
        myList.remove(2);
        for (Object element :  myList.getAll()) {
            System.out.println(element);
        }
        System.out.println("--------------------------------\nGet: " + myList.get(3));

    }
}