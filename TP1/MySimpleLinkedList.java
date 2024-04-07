package TP1;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable <T>> implements Iterable<T> {
    private Node<T> first;

    public MySimpleLinkedList() {
        this.first = null;
    }

    //EJERCICIO 1

    //Insertar al principio de la lista
    //Complejidad computacional: O(1) --- Solo setea el primer nodo de la lista y le encadena como siguiente el anterior primer nodo
    public void insertFront(T info) {
        Node<T> tmp = new Node<>(info,null);
        tmp.setNext(this.first);
        this.first = tmp;
    }

    //Comportamiento de pila, saca el primero de la lista y lo retorna
    //Complejidad computacional: O(1) --- Guarda la informacion del noto que va a extraer y lo quita de la lista
    public T extractFront() {
        T info = this.first.getInfo();
        this.first = this.first.getNext();
        return info;
    }

    //Complejidad computacional: O(1)
    public boolean isEmpty() {
        return this.first == null;
    }

    //Retorna el valor de un nodo dada su posicion dentro de la lista, en caso de no encontrarlo retorna null
    //Complejidad computacional: O(n) --- En el peor de los casos, debe recorrer la lista entera (n es es el tamaño de la lista)
    public T get(int index) {
        if(index<=this.size()){
            int i = 0;
            Node<T> aux = this.first;
            while ((i<index)&&(aux.getNext()!=null)){
                aux = aux.getNext();
                i++;
            }
            if(i==index){
                return aux.getInfo();
            }
        }
        return null;
    }

    public int size() {
        if(!this.isEmpty()){
            int size = 1;
            Node<T> aux = this.first;
            while ((aux!=null)&&(aux.getNext()!=null)){
                size++;
                aux = aux.getNext();
            }
            return size;
        }
        return 0;
    }

    //Ejercicio 3
    public int indexOf(T n){
        if(!this.isEmpty()){
            int i = 0;
            Node<T> tmp = this.first;
            //T info = tmp.getInfo();
            while ((tmp!=null)&&(tmp.getInfo()!=n)){
                tmp = tmp.getNext();
                i++;
            }
            if((tmp!=null)&&(tmp.getInfo()==n)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        String info = "";
        if (!this.isEmpty()) {
            Node<T> tmp = this.first;
            info += tmp.getInfo();

            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
                info += "--->" + tmp.getInfo();
            }
        }
        return "[" + info + "]";
    }

    //Ejercicio 4
    @Override
    public Iterator<T> iterator() {
        return new MyIterator<>(this.first);
    }

    //Ejercicio 5

    public MySimpleLinkedList<T> getElementosComunes (MySimpleLinkedList<T> listaB){
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();

        for (Node<T> nodoA = this.first; nodoA!= null; nodoA=nodoA.getNext()){
            Node<T> nodoB = listaB.first;

            while((!nodoA.getInfo().equals(nodoB.getInfo()))&&(nodoB.getNext()!=null)){
                nodoB = nodoB.getNext();
            }
            if (nodoA.getInfo().equals(nodoB.getInfo())){
                resultado.insertOrdenado(nodoB);
                //resultado.insertFront(nodoB.getInfo());
            }
        }
        return resultado;
    }

    //REVISAR ESTE METODO
    private void insertOrdenado(Node<T> aux) {
        if (this.isEmpty()){
            this.insertFront(aux.getInfo());
        } else {
            Node<T> tmp = this.first;
            //while ((int)tmp.getInfo()<(int)aux.getInfo()){
            while ((tmp.getNext()!=null)&&(tmp.getInfo().compareTo(aux.getInfo()))>0){
                tmp = tmp.getNext();
            }
            //Node<T> next = tmp.getNext();
            aux.setNext(tmp.getNext());
            tmp.setNext(aux);
            //tmp.getNext().setNext(next);
        }
    }

    //Ejercicio 6

    public MySimpleLinkedList<T> diferenciarLista (MySimpleLinkedList<T> listaB) {
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();

        for (Node<T> n = this.first; n.getNext()!= null; n=n.getNext()){
            Node<T> aux = listaB.first;
            while ((!aux.getInfo().equals(n.getInfo()))&&(aux.getNext()!=null)){
                aux = aux.getNext();
            }
            if (!aux.getInfo().equals(n.getInfo())){
                resultado.insertFront(n.getInfo());
            }
        }
        return resultado;
    }
}

