package org.example;

public class MyBST {


    Node root;
    int height;

    public MyBST() {
        root = null;
    }

    public MyBST(int value) {
        root = new Node(value);
        height = 1;
    }

    public MyBST(Node root) {
        this.root = root;
    }

    public void add(int value) {
        if (this.root == null) this.root = new Node(value);
        else {
            Node temp = this.root;
            Node newNode = new Node(value);
           while (true){
               if (temp.data>value){
                   if (temp.left==null) {temp.left=newNode; break;}
                   else {temp=temp.left;}
               }else {
                   if (temp.right==null) {temp.right=newNode; break;}
                   else {temp=temp.right;}
               }
           }
        }
    }
}