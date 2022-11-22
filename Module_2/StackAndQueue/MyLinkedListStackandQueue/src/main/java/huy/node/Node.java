package huy.node;

public class Node<E> {
    private E value;
    private Node<E> next;

    public Node() {
    }

    public Node(E value) {
        this.value = value;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getValue() {
        return value;
    }

    @Override
    public String toString() {
       return "value: " + this.getValue();
    }

}
