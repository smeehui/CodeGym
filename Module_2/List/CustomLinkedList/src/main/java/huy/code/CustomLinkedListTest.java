package huy.code;

public class CustomLinkedListTest {
    public static void main(String[] args) {
//        Node<Integer> node1 = new Node<>(10);
//        Node<Integer> node2 = new Node<>(20);
//        Node<Integer> node3 = new Node<>(30);
//        CustomLinkedList<Integer> myList = new CustomLinkedList<>(node1);
//        myList.addFist(node2);
//        myList.addFist(node3);
//        myList.add(3, 6);
//        myList.addLast(new Node<>(99));
//        System.out.println(myList);
//        System.out.println(myList.getLast());
//        System.out.println();
//
//        System.out.println("Remove at index: 2 ");
//        System.out.println("Removed: " + myList.remove(2) + ", " + myList);
//
//
//        System.out.println("Clone list:");
//        CustomLinkedList<Integer> clone = myList.clone();
//        System.out.println(clone);
//        System.out.println();
//
//        System.out.println("Check if clone list contain number 99: " + clone.contains(99));
//        System.out.println();
//
//        System.out.println("Get value of clone list at index: 3 ");
//        System.out.println(clone.get(3));
//        System.out.println();
//
//        try {
//            System.out.println("Get value of clone list at index: 99 ");
//            System.out.println(clone.get(99));
//            System.out.println();
//        } catch (Exception e) {
//            System.out.println("Error: " + e.getMessage());
//        }
//        System.out.println();
//
//        System.out.println("Clear clone list");
//        clone.clear();
//        System.out.println(clone);
//        System.out.println();

        CustomLinkedList<String> list = new CustomLinkedList<>("Program");
        System.out.println("Empty list: " + list);
        list.add(1,"Hello");
        list.addLast(new Node<>("World"));

        System.out.println("List 2: " + list);
        System.out.println(list.getLast());
        System.out.println();

        System.out.println("Remove Hello");
        System.out.println("Status: " + list.remove("Hello") + ", " + list);
        System.out.println();

        System.out.println("Remove World");
        System.out.println("Status: " + list.remove("World") + ", " + list);

        CustomLinkedList<Integer> intergerList = new CustomLinkedList<>();
        intergerList.add(10);
        intergerList.add(20);
        intergerList.add(30);
        intergerList.add(40);
        System.out.println(intergerList);
        CustomLinkedList<String> StringList = new CustomLinkedList<>("Hello","I'm","Huy", "23", "age");
        System.out.println(StringList);
        StringList.reverse();
        System.out.println(StringList);
    }
}