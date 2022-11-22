package huy.linkedListQueue;
import huy.node.Node;

import java.util.Arrays;

public class MyLinkedQueue<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;
    public MyLinkedQueue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public MyLinkedQueue(T value) {
        head = new Node<>(value);
        tail = head;
        size = 1;
    }

    public boolean enqueue(T value) {
        Node<T> newNode = new Node<>(value);
        if (isEmpty()) {
            head= newNode;
            tail= head;
            size=1;
            return true;
        }
        if(isFull()) return false;
        this.tail.setNext(newNode);
        this.tail= newNode;
        size++;
        return true;
    }
    public Node<T> dequeue() {
        if (isEmpty()) return null;
        Node<T> temp = this.head;
        this.head = temp.getNext();
        size--;
        return temp;
    }


    public boolean isEmpty() {
        return this.head==null;
    }

    public boolean isFull() {
        return false;
    }

    public void clear() {
        this.head=null;
        size=0;
    }

    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "MyLinkedQueue{" +
                "head=" + Arrays.toString(toArray()) +
                ", size=" + size +
                '}';
    }
    public T[] toArray() {
        Object[] array = new Object[size];
        Node<T> temp = head;
        for (int i = 0; i < size; i++) {
            array[i] = temp.getValue();
            temp = temp.getNext();
        }
        return (T[]) array;
    }
}
