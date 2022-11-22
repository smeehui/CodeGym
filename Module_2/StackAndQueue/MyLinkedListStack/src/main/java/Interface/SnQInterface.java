package Interface;

public interface SnQInterface<T> {
    boolean push(T value);
    T pop();
    T peek();
    boolean isEmpty();
    boolean isFull();
    void clear();
    int size();
}
