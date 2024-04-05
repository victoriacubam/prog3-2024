package TP1;

import java.sql.SQLOutput;

public class Main {
    public static void main (String[]args){
    MySimpleLinkedList<Node<String>> lista = new MySimpleLinkedList<>();

    Node<String> n1 = new Node<String>();
    Node<String> n2 = new Node<String>();
    Node<String> n3 = new Node<String>();

    n1.setInfo("1");
    n2.setInfo("2");
    n3.setInfo("3");

    lista.insertFront(n1);// 1
    lista.insertFront(n2);// 2,1
    lista.insertFront(n3);// 3,2,1

    System.out.println("Esta vacia: " + lista.isEmpty());
    System.out.println("Tamaño: " + lista.size());
    System.out.println("Posicion de "+ n1 + ": " + lista.indexOf(n1));
    System.out.println("Nodo en posicion 2: " + lista.get(2));
    System.out.println(lista);
    }
}