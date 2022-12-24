package org.example;

class Node implements Comparable<Node> {
    int data;
    Node left;

    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public int compareTo(Node o) {
        return this.data > o.data ? 1 : this.data < o.data ? -1 : 0;
    }
}
