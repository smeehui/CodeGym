package huy.code;

public class Node<E> {
    private E data;
    private Node<E> link;
    public Node(){}
    public Node(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getLink() {
        return link;
    }
    public void setLink(Node<E> link) {
        this.link = link;
    }
}
