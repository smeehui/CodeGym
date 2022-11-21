package huy.code;

import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        int[] numbers = {0, 1, 2, 3, 4};
        for (int number : numbers) {
            myList.add(number);
        }
        System.out.println("Initial list: " + Arrays.toString(myList.getAll()));
        System.out.println();
        System.out.println("Add number: 5");
        boolean status = myList.add(5);
        System.out.println(myList+ "\nstatus: " + status);
        System.out.println("Add number: 99 a index: 2");
        myList.add(2,99);
        System.out.println(myList);
        System.out.println();
        System.out.println("Remove at index: 2");
        Integer removedElement = myList.remove(2);
        System.out.println(myList + "\nRemoved: " + removedElement);
        System.out.println();
        System.out.println("Get element at index: 1");
        System.out.println(myList.get(1));
        System.out.println();
        System.out.println("Get index of: 5");
        System.out.println("Index of 5: "+myList.indexOf(5));
        System.out.println();
        System.out.println("Clone list");
        MyList<Integer> clone = myList.clone();
        System.out.println("Cloned list: " + clone);
        System.out.println();
        System.out.println("Get size list");
        System.out.println(myList.size());
        System.out.println();
        System.out.println("Cheking if list contains number: 6");
        System.out.println(myList.contains(6));
        System.out.println();
        System.out.println("Cheking if list contains number: 3");
        System.out.println(myList.contains(3));
        System.out.println();
        System.out.println("Clear list");
        myList.clear();
        System.out.println(myList);
    }
}