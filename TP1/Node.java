package TP1;

public class Node<T> {
    private T info;
    private Node<T> next;
    //Si se quisiera hacer doblemente vinculada habria que agregar un atributo PREV
    // que guarde un puntero hacia el nodo anterior

    public Node() {
        this.info = null;
        this.next = null;
    }

    public Node(T info, Node<T> next) {
        this.setInfo(info);
        this.setNext(next);
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String toString() {
        return "[" + this.getInfo().toString() + "]";
    }

    public boolean equals(Node<T> n) {
        return this.getInfo().equals(n.getInfo());
    }
}