package huy.code;

public class CustomLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int numNodes;

    public CustomLinkedList() {
    }
    @SafeVarargs
    public CustomLinkedList(E... args) {
        for (E e : args) {
            Node<E> newNode = new Node<>(e);
            this.addLast(newNode);
        }
    }

    public CustomLinkedList(E value) {
        Node<E> newNode = new Node<>(value);
        this.head = newNode;
        this.tail = newNode;
        numNodes = 1;
    }

    public CustomLinkedList(Node<E> head) {
        this.head = head;
        numNodes = 1;
        this.tail = this.setTail();
    }

    public Node<E> setTail() {
        Node<E> newTail = this.head.getNext();
        Node<E> checkNull = newTail;
        if (newTail == null) return head;
        else while (checkNull != null) {
            numNodes++;
            newTail = checkNull;
            checkNull = checkNull.getNext();
        }
        return newTail;
    }


    public Node<E> getFirst() {
        return this.head;
    }

    public Node<E> getLast() {
        return this.tail;
    }

    public void addFist(Node<E> node) {

        if (this.head == null) {
            this.head = node;
            this.tail = node;
            numNodes = 1;
        } else {
            node.setNext(head);
            this.setHead(node);
            numNodes++;
        }
    }

    public void addLast(Node<E> node) {
        if (this.head == null) {
            this.head = node;
            this.tail = node;
            numNodes = 1;
        } else {
            this.tail.setNext(node);
            this.tail = node;
            numNodes++;
        }
    }
    public boolean add(E value) {
        Node<E> newNode = new Node<>(value);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
            numNodes = 1;
            return true;}
        else {
            newNode.setNext(this.head);
            this.head = newNode;
            numNodes++;
            return true;
        }
    }
    public void add(int index, E value) {
        Node<E> newNode = new Node<>(value);
        Node<E> temp = this.head;
        if (index > numNodes || index < 0) throw new IndexOutOfBoundsException();
        if (temp == null) this.addFist(new Node<>(value));
        else if (index == 0) this.addFist(newNode);
        else if (index == numNodes) this.addLast(newNode);
        else {
            int count = 1;
            while (temp.getNext() != null) {
                if (count == index) {
                    newNode.setNext(temp.getNext());
                    temp.setNext(newNode);
                    break;
                }
                temp = temp.getNext();
                count++;
            }
            numNodes++;
        }
    }

    public E remove(int index) {
        Node<E> temp = this.head;
        if (index > numNodes || index < 0) throw new IndexOutOfBoundsException();
        if (temp == null) return null;
        if (index == 0) {
            head = temp.getNext();
            numNodes--;
            return temp.getValue();
        }
        int count = 1;
        while (temp.getNext() != null) {
            if (count == index) {
                Node<E> delNode = temp.getNext();
                temp.setNext(temp.getNext().getNext());
                numNodes--;
                return delNode.getValue();
            }
            temp = temp.getNext();
            count++;
        }
        return temp.getValue();
    }

    public boolean remove(E value) {
        Node<E> temp = this.head;
        if (temp == null) return false;
        while (temp!= null) {
            if (temp.getNext().getValue().equals(value)) {
                temp.setNext(temp.getNext().getNext());
                numNodes--;
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public CustomLinkedList<E> clone() throws CloneNotSupportedException {
        super.clone();
        Node<E> temp = this.head;
        if (temp == null) return null;
        Node<E> newNode = new Node<>(temp.getValue());
        newNode.setNext(temp.getNext());
        return new CustomLinkedList<>(newNode);
    }

    public boolean contains(E value) {
        Node<E> temp = this.head;
        if (temp == null) return false;
        while (temp != null) {
            if (temp.getValue().equals(value)) return true;
            temp = temp.getNext();
        }
        return false;
    }

    public E get(int index) {
        Node<E> temp = this.head;
        if (temp == null) return null;
        if (index > numNodes || index < 0) throw new IndexOutOfBoundsException();
        if (index == 0) return this.getFirst().getValue();
        if (index == numNodes - 1) return this.getLast().getValue();
        int count = 0;
        while (temp != null) {
            if (count == index) return temp.getValue();
            count++;
            temp = temp.getNext();
        }
        return null;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.numNodes = 0;
    }
    public void reverse() {
        Node<E> oldHead = this.head;
        Node<E> cur = this.head;
        Node<E> prev = null;
        while(cur!= null) {
            Node<E> next = cur.getNext();
            cur.setNext(prev);
            prev = cur;
            cur = next;
        }
        this.setHead(prev);
        this.tail = oldHead;
    }

    private void setHead(Node<E> node) {
        this.head = node;
    }

    public int size() {
        return numNodes;
    }

    @Override
    public String toString() {
        Node<E> temp = head;
        StringBuilder sb = new StringBuilder();
        sb.append("Nodes: ").append(this.size()).append(" ").append("Head: ").append(head.getValue()+", ");
        while (true) {
            if (temp == null) {
                sb.append("null ");
                break;
            }
            sb.append(temp.getValue()).append("-->");
            temp = temp.getNext();
        }
        sb.append("Tail: ").append(tail.getValue());
        return sb.toString();
    }
}
