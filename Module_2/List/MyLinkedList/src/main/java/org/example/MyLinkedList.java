package org.example;

public class MyLinkedList {
    private Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
    }

    public MyLinkedList(Node head) {
        this.head = head;
        countNodes();
    }

    private void countNodes() {
        Node temp = head;
        while (temp != null) {
            numNodes++;
            temp = temp.next;
        }
    }

    public int getNumNodes() {
        return numNodes;
    }

    public void printList() {
        if (head == null) System.out.println("Emty");
        else {
            System.out.println("Numbers of node:" + this.getNumNodes() + " nodes");
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.getData() + " ");
                temp = temp.next;
                if (temp != null) System.out.print("->");
                else System.out.println();
            }
        }
    }

    public void addFirst(Object value) {
        Node newNode = new Node(value);
        if (head != null) {
            newNode.next = head;
            numNodes++;
        }
        head = newNode;
    }

    public void add(int index, Object value) {
        Node newNode = new Node(value);
        Node curentNode = head;
        int count = 0;
        if (index == 0) {
            this.addFirst(value);
        } else while (curentNode != null) {
            count++;
            if (count == index) {
                newNode.next = curentNode.next;
                curentNode.next = newNode;
                numNodes++;
                break;
            }
            curentNode = curentNode.next;
        }
    }

    public void removeFirst() {
        if (head == null) System.out.println("Emty");
        else {
            head = head.next;
            numNodes--;
        }
    }

    public void remove(int index) {
        if (index < 0 || index >= numNodes) throw new IndexOutOfBoundsException();
        else if(index ==0) removeFirst();
        else {
            Node curentNode = head;
            int count = 0;
            while (curentNode != null) {
                count++;
                if (index-1 == count) {
                    curentNode.next = curentNode.next.next;
                    numNodes--;
                    break;
                }
                curentNode = curentNode.next;
            }
        }
    }
}
