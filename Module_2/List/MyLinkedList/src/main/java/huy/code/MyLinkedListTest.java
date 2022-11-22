package huy.code;

public class MyLinkedListTest {
    public static void main(String[] args) {
        Node node1 = new Node("love");
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.next = node2;
        node2.next = node3;
        MyLinkedList list = new MyLinkedList(node1);
        list.printList();
        list.addFirst(4);
        list.printList();
        list.add(0,-1);
        list.printList();
        list.add(5,5);
        list.printList();
        list.removeFirst();
        list.printList();
        list.remove(3);
        list.printList();
        list.remove(3);
        list.printList();
    }
}