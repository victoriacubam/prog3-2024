package TP3;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    public Tree() {
        this.root = null;
    }

    public int getRoot() {
        return this.root.getKey();
    }

    public boolean hasElem(Integer elem) {
        return false;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(Integer key) {
        //Si esta vacio lo inserto en la raiz
        if (this.isEmpty())
            this.root = new Node(key);
        else
            //No esta vacio entonces le paso la raiz para que empiece a buscar donde insertarlo
            this.insert(this.root, key);
    }

    private void insert(Node nodo, Integer key) {
        //Si es mayor al nodo actual voy por la der
        if (nodo.getKey() < key) {
            //Si tiene der sigo buscando
            if (nodo.getRight() != null)
                insert(nodo.getRight(), key);
                //El nodo no tiene der entonces lo agrego como nodo der
            else
                nodo.setRight(key);
        }
        //Si es menor al nodo actual voy por la izq
        else if (nodo.getKey() > key) {
            //Si tiene izq sigo la recursion
            if (nodo.getLeft() != null)
                insert(nodo.getLeft(), key);
                //Si no tiene iz lo agrego como izq
            else
                nodo.setLeft(key);
        }
    }

    public boolean delete(Integer clave) {
        //Si lo encuentra lo borra y retorna true
        //Cuando lo borra debe hacer las conexiones para que el arbol quede bien
        //Si termino de recorrer y no lo encuentra retorna false
        return true;
    }

    public int getHeight() {
        return getHeight(this.root);
    }

    private int getHeight(Node n) {
        int heightLeft = 0;
        int heightRight = 0;

        if (this.isEmpty())
            return 0;
            //Si no esta vacio lo recorro
        else {
            if (n.getLeft() != null)
                heightLeft = getHeight(n.getLeft());
            if (n.getRight() != null)
                heightRight = getHeight(n.getRight());
        }
        return 1 + Math.max(heightLeft, heightRight);
    }


    //POST ORDER Primero izq izq izq der der der imprimo
    //PRE ORDER Primero imprimo izq der
    //IN ORDER izq imprimo der

    //Recursivamente obtener los datos del subárbol izquierdo
    //Recursivamente obtener los datos del subárbol derecho
    //Imprimir el dato de la raíz
    public void printPosOrder() {
        if (this.isEmpty()) {
            System.out.println("Pos Order: Esta vacío");
        } else {
            System.out.print("Pos Order: ");
            printPosOrder(this.root);
            System.out.println();
        }
    }

    private void printPosOrder(Node n) {
        if (n.getLeft() != null)
            printPosOrder(n.getLeft());
        else
            System.out.print("- ");
        if (n.getRight() != null)
            printPosOrder(n.getRight());
        else
            System.out.print("- ");

        System.out.print(n + "  ");
    }

    //Imprimir el dato de la raíz
    //Recursivamente obtener los datos del subárbol izquierdo
    //Recursivamente obtener los datos del subárbol derecho
    public void printPreOrder() {
        if (this.isEmpty()) {
            System.out.println("Pre Order: Esta vacío");
        } else {
            System.out.print("Pre Order: ");
            printPreOrder(this.root);
            System.out.println();
        }
    }

    private void printPreOrder(Node n) {
        System.out.print(n + "  ");
        if (n.getLeft() != null)
            printPreOrder(n.getLeft());
        else
            System.out.print("- ");
        if (n.getRight() != null)
            printPreOrder(n.getRight());
        else
            System.out.print("- ");
    }

    //Recursivamente obtener los datos del subárbol izquierdo
    //Imprimir el dato de la raíz
    //Recursivamente obtener los datos del subárbol derecho
    public void printInOrder() {
        if (this.isEmpty()) {
            System.out.println("In Order: Esta vacío");
        } else {
            System.out.print("In Order: ");
            printInOrder(this.root);
            System.out.println();
        }
    }

    private void printInOrder(Node n) {
        if (n.getLeft() != null)
            printInOrder(n.getLeft());
        else
            System.out.print("- ");

        System.out.print(n + "  ");

        if (n.getRight() != null)
            printInOrder(n.getRight());
        else
            System.out.print("- ");
    }

    // List getLongestBranch(),
    public List<Integer> getFrontera(){//Hojas
        List <Integer> frontera = new ArrayList<>();
        Node n = this.root;

        while (n.getRight()!=null || n.getLeft()!=null){
            

        }


        //No tiene nodos a la derecha ni a la izquiera -> es HOJA
        if (n.getRight()==null && n.getLeft()==null){
            frontera.add(n.getKey());
        }
        return frontera;
    }
    public Integer getMaxElem(){
        //Sin recursion
        Node aux = this.root;
        if (this.isEmpty()){
            return null;
        }
        //Mientras que exista un nodo a la derecha
        while (aux.getRight() != null){
            aux = aux.getRight();
        }
        //Devuelve el nodo mas a la derecha
        return aux.getKey();

        /*
        //Con recursion
        Integer max = this.root.getKey();
        if (this.root.getRight()!= null){
            getMaxElem(this.root.getRight(), max);
        }
        return max;
        */
    }

    // List getElemAtLevel(int)
}
