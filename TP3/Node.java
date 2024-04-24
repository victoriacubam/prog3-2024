package TP3;

public class Node {
    Integer key;
    Node left, right;

    public Node(Integer key){
        this.key = key;
        this.left = null;
        this.right = null;
    }

    public int getKey(){
        return this.key;
    }

    public void setLeft(Integer left){
        this.left = new Node(left);
    }

    public void setRight(Integer right){
        this.right = new Node(right);
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public String toString() {
        return this.key.toString();
    }

}
