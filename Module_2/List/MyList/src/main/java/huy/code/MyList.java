package huy.code;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    public static final int DEFAULT_CAPACITY = 5;
    private Object[] elements;


    public Object[] getAll() {
        return this.elements;
    }

    public MyList() {
        this.elements = new Object[MyList.DEFAULT_CAPACITY];
    }

    public void add(E element) {
        if (size == elements.length) ensureCapa();
        this.elements[size++] = element;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        this.elements[index] = null;
        for (int i = index; i < size; i++){
            this.elements[i] = this.elements[i+1];
        }
        size--;
    }
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (E)this.elements[index];
    }
    private void ensureCapa() {
        int newSize = this.elements.length+  MyList.DEFAULT_CAPACITY;
        this.elements = Arrays.copyOf(this.elements,newSize);
    }
}
