package huy.code;

public class Main {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>(90);
        queue.enqueue(80);
        queue.enqueue(70);
        queue.enqueue(60);
        queue.display();
        System.out.println("Dequeue");
        queue.dequeue();
        queue.display();

        queue.dequeue();
        queue.display();

        queue.dequeue();
        queue.display();

        queue.dequeue();
        queue.display();
    }
}