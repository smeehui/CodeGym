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

    public boolean add(E element) {
        if (size == elements.length) ensureCapa();
        this.elements[size++] = element;
        return true;
    }
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for (int i = index; i < size; i++){
            this.elements[i] = this.elements[i+1];
        }
        size--;
        return (E)this.elements[index];
    }
    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return (E)this.elements[index];
    }

    public int size() {
        return size;
    }
    @Override
    public MyList<E> clone(){
        MyList<E> list = new MyList<>();
        for (int i = 0; i < size; i++){
            list.add((E)this.elements[i]);
        }
        return list;
    }
    public  boolean contains(E element){
        for (int i = 0; i < size; i++){
            if (this.elements[i].equals(element)){
                return true;
            }
        }
        return false;
    }
    public int indexOf(E element){
        for (int i = 0; i < size; i++){
            if (this.elements[i].equals(element)){
                return i;
            }
        }
        return -1;
    }
    public void clear() {
        for (int i = 0; i < size; i++){
            this.elements[i] = null;
        }
    }
    private void ensureCapa() {
        int newSize = this.elements.length+  MyList.DEFAULT_CAPACITY;
        this.elements = Arrays.copyOf(this.elements,newSize);
    }

    @Override
    public String toString() {
        return "MyList{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
    public void add(int index, E element){
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for (int i = size; i>index; i--){
            this.elements[i]=this.elements[i-1];
        }
        this.elements[index] = element;
        size++;
    }
}
