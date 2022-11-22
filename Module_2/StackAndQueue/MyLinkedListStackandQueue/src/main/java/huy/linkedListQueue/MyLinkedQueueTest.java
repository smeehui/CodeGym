package huy.linkedListQueue;

public class MyLinkedQueueTest {
    public static void main(String[] args) {
        MyLinkedQueue<Integer> queue = new MyLinkedQueue<>();
        System.out.println("Enqueue status: " + queue.enqueue(1));
        System.out.println("Enqueue status: " + queue.enqueue(2));
        System.out.println("Enqueue status: " + queue.enqueue(3));
        System.out.println("Enqueue status: " + queue.enqueue(4));
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println();
        System.out.println("Clear queue:");
        System.out.println("Enqueue status: " + queue.enqueue(1));
        System.out.println("Enqueue status: " + queue.enqueue(2));
        System.out.println("Enqueue status: " + queue.enqueue(3));
        System.out.println("Enqueue status: " + queue.enqueue(4));
        queue.clear();
        System.out.println(queue);

    }
}
