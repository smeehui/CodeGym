package huy.code;

import Interface.SnQInterface;
import java.util.Arrays;

public class MyLinkedListStack<T> implements SnQInterface<T> {
    private Node<T> topNode;

    public MyLinkedListStack() {
        this.topNode = null;
    }

    public MyLinkedListStack(T value) {
        this.topNode = new Node<>(value);
    }

    public boolean push(T value) {
        if (isFull()) return false;
        else {
            Node<T> newNode = new Node<>(value);
            newNode.setNext(this.topNode);
            this.topNode = newNode;
            return true;
        }
    }

    public T pop() {
        if (isEmpty()) return null;
        else {
            Node<T> temp = this.topNode;
            this.topNode = this.topNode.getNext();
            return temp.getValue();
        }
    }

    public T peek() {
        if (isEmpty()) return null;
        else {
            return this.topNode.getValue();
        }
    }

    public boolean isEmpty() {
        return topNode == null;
    }

    public boolean isFull() {
        return false;
    }

    public void clear() {
        this.topNode = null;
    }

    public int size() {
        int count = 0;
        Node<T> temp = this.topNode;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Empty";
        return "MyLinkedListStack, size: " + size() + " {" +
                "topNode= " + Arrays.toString(toArray()) +
                '}';
    }

    public T[] toArray() {
        if (isEmpty()) return null;
        else {
            Object[] array = new Object[size()];
            Node<T> temp = this.topNode;
            int i = size()-1;
            while (temp!= null) {
                array[i] = temp.getValue();
                i--;
                temp=temp.getNext();
            }
            return (T[])array ;
        }
    }
}
