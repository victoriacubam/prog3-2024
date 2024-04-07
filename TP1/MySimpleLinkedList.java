package TP1;

import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable <T>> {
    private Node<T> first;
    private Node<T> last;

    public MySimpleLinkedList() {
        this.first = null;
        this.last = null;
    }

    /*
    EJERCICIO 1: Implemente los métodos indicados del esqueleto de Lista desarrollado en Teoría (
    void insertFront(T), T extractFront(), boolean isEmpty(), int size(),
    String toString). Agregar también el método: T get(index).
    */


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

    //Retorna el tamaño de la lista, una alternativa es guardar el tamaño como un atributo de la clase
    //Complejidad computacional: O(n) --- Si esta vacia retornará 0, pero en el peor de los casos debe recorrerla entera (n es el tamaño de la lista)
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

    /*
    EJERCICIO 3: A la implementación de la clase Lista realizada en el ejercicio 1, agregue un método
    int indexOf(T), que reciba un elemento y retorne el índice donde está almacenado ese
    elemento, o -1 si el elemento no existe en la lista.
    */

    //Dado un elemento retornará el indice donde se encuenta ese elemento dentro de la lista. En caso de no hallarse, retorna -1
    //Complejidad computacional: O(n) --- En el peor de los casos deberá recorrer toda la lista. (n es el tamaño de la lista)
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

    /*
    EJERCICIO 4: A partir de la clase Lista implementada en el ejercicio 1, implemente el patrón
    iterator-iterable, para que la lista sea iterable.
    ¿Existe alguna ventaja computacional a la hora
    de recorrer la lista de principio a fin si se cuenta con un iterador?
    ---La ventaja será que existirá un cursor que recuerda la posición, por lo que la lista no se debe
    recorrer desde el principio en cada llamado
    */

    public MyIterator<T> MyIterador() {
        return new MyIterator<>(this.first);
    }

    /*
    EJERCICIO 5: Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
    suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar ordenada. b)
    Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
    */

    //a) Las listas están desordenadas y la lista resultante debe quedar ordenada
    public MySimpleLinkedList<T> getElementosComunesListasDesordenadas(MySimpleLinkedList<T> listaB){
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();
        for (Node<T> a = this.first; a.getNext()!= null; a = a.getNext()){
            Node<T> b = listaB.first;
            boolean found = false;
            while (b!= null && !found){
                if (a.getInfo().equals(b.getInfo())){
                    resultado.insertOrdenado(a.getInfo());
                    found = true;
                } else {
                    b = b.getNext();
                }
            }
        }

        return resultado;

        /*//Sin iterador
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
        return resultado;*/
    }

    private void insertOrdenado(T info){
        Node<T> aux = this.first;
        //Si esta vacio o lo tiene que insertar al principio porque es menor que el primero
        if (this.isEmpty() || (aux.getInfo().compareTo(info)>0)){
            this.insertFront(info);
        } else {
            while (aux.getNext()!=null && (aux.getInfo().compareTo(info)<0)){
                aux = aux.getNext();
            }
            //Lo tiene que insertar al final porque llegó al final de la lista
            if (aux.getNext()==null){
                aux.setNext(new Node<>(info, null));
            }
            //Lo tiene que insertar entremedio
            else {
                Node<T> next = aux.getNext();
                aux = new Node<>(info, next);
            }
        }
    }

    //b) Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
    public MySimpleLinkedList<T> getElementosComunesListasOrdenadas(MySimpleLinkedList<T> listaB){
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();
        MyIterator<T> itListaA = this.MyIterador();
        MyIterator<T> itListaB = listaB.MyIterador();
        while (itListaA.hasNext() && (itListaB.hasNext())){
            if (itListaA.value().compareTo(itListaB.value())>0){
                itListaB.next();
            }
            else if (itListaA.value().compareTo(itListaB.value())<0) {
                itListaA.next();
            }
            else {
                resultado.insertLast(itListaA.value());
                itListaA.next();
                itListaB.next();
            }
        }

        return resultado;

        /*//Sin iterador
        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();
        Node<T> nodoA = this.first;
        Node<T> nodoB = listaB.first;
        while ((!nodoA.getInfo().equals(nodoB.getInfo()))&&(nodoA.getNext()!=null)){
            boolean found = false;
            //Mientras que nodoA sea MENOR a nodoB va a seguir buscando en la lista B
            while ((nodoA.getInfo().compareTo(nodoB.getInfo())<0)&&(nodoB.getNext()!=null)&&!found){
                if(!nodoA.getInfo().equals(nodoB.getInfo())){
                    nodoB = nodoB.getNext();
                } else {
                    //resultado.insertOrdenado(nodoA);
                    resultado.insertFront(nodoB.getInfo());
                    found = true;
                    nodoB = nodoB.getNext();
                }
            }
            nodoA = nodoA.getNext();
        }
        return resultado;*/
    }
    private void insertLast(T info) {
        if(this.isEmpty()){
            this.first = new Node<>(info, null);
            this.last = this.first;
        } else {
            Node<T> aux = new Node<>(info, null);
            this.last.setNext(aux);
            this.last = aux;
        }
    }




    /*//REVISAR ESTE METODO
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
    }*/

    /*
    EJERCICIO 6: Escriba una función que dadas dos listas construya otra con los elementos que están en la
    primera pero no en la segunda.
     */

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

