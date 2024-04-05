package TP1;

import java.sql.SQLOutput;
import java.util.Iterator;

public class Main {
    public static void main (String[]args){
        MySimpleLinkedList<Integer> lista = new MySimpleLinkedList<>();

        lista.insertFront(1);// 1
        lista.insertFront(2);// 2,1
        lista.insertFront(3);// 3,2,1

        System.out.println("Esta vacia: " + lista.isEmpty());
        System.out.println("Tamaño: " + lista.size());
        System.out.println("Posicion de "+ 1 + ": " + lista.indexOf(1));
        System.out.println("Nodo en posicion 2: " + lista.get(2));
        System.out.println("Lista: " + lista);

        Iterator<Integer> it = lista.iterator();

        while (it.hasNext()){
            Integer i = it.next();
            System.out.println(i);
        }
    }
}