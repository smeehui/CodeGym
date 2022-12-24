package huy.code;

public class Queue<E> {
    private Node<E> front;
    private Node<E> rear;
    private int numNodes;
    public Queue(){}
    public Queue(E value){
        this.front = new Node<>(value);
        this.rear = this.front;
        this.front.setLink(this.rear);
        numNodes = 1;
    }
    public void enqueue(E value){
        if(this.front==null){
            this.setFront(new Node<>(value));
            this.setRear(this.getFront());
            this.front.setLink(this.rear);
            numNodes=1;
        }else {
            Node<E> newNode = new Node<>(value);
            this.getRear().setLink(newNode);
            newNode.setLink(this.getFront());
            this.setRear(newNode);
            numNodes++;
        }
    }
    public void dequeue(){
        if(this.front.equals(this.rear)) this.setFront(null);
        else {
            Node<E> frontNode = this.getFront();
            this.setFront(frontNode.getLink());
            this.rear.setLink(this.getFront());
            numNodes--;
        }
    }
    public Node<E> getFront() {
        return front;
    }

    public void setFront(Node<E> front) {
        this.front = front;
    }

    public Node<E> getRear() {
        return rear;
    }

    public void setRear(Node<E> rear) {
        this.rear = rear;
    }

    public void display() {
        Node<E> currentNode = this.getFront();
        StringBuilder sb = new StringBuilder();
        String str= "Empty circular queue";
        if (currentNode != null) {
            while(true){
                if(currentNode.equals(this.rear)){
                    sb.append(currentNode.getData());
                    break;
                }
                sb.append(currentNode.getData()).append("-->");
                currentNode = currentNode.getLink();
            }
            str = "Queue{" +
                    "front=" + this.getFront().getData() +", ["+ sb+"]"+
                    ", rear=" + this.getRear().getData() +
                    '}'+", nodes: "+ this.numNodes;
        }
        System.out.println(str);
    }
}
