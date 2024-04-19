package TP3;

public class Tree {
    private Node root;

    public Tree(){
        this.root = null;
    }

    public int getRoot (){
        return this.root.getKey();
    }

    public boolean hasElem (Integer elem) {
        return false;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public void insert(Integer key){
        //Si esta vacio lo inserto en la raiz
        if (this.isEmpty())
            this.root = new Node(key);
        else
            //No esta vacio entonces le paso la raiz para que empiece a buscar donde insertarlo
            this.insert(this.root, key);
    }

    private void insert(Node nodo, Integer key){
        //Si es mayor al nodo actual voy por la der
        if (nodo.getKey() < key){
            //Si tiene der sigo buscando
            if (nodo.getRight()!=null)
                insert(nodo.getRight(), key);
            //El nodo no tiene der entonces lo agrego como nodo der
            else
                nodo.setRight(key);
        }
        //Si es menor al nodo actual voy por la izq
        else if (nodo.getKey() > key){
            //Si tiene izq sigo la recursion
            if (nodo.getLeft()!=null)
                insert(nodo.getLeft(), key);
            //Si no tiene iz lo agrego como izq
            else
                nodo.setLeft(key);
        }
    }

    public boolean delete(Integer clave){
        //Si lo encuentra lo borra y retorna true
        //Si termino de recorrer y no o encuentra retorna false
        return true;
    }

    public int getHeight(){
        return getHeight(this.root);
    }

    private int getHeight(Node n){
        int heightLeft = 0;
        int heightRight = 0;

        if (this.isEmpty())
            return 0;
        //Si no esta vacio lo recorro
        else {
            if (n.getLeft()!=null)
                heightLeft = getHeight(n.getLeft());
            if (n.getRight()!=null)
                heightRight = getHeight(n.getRight());
        }
        return 1 + Math.max(heightLeft, heightRight);
    }

/*
    private int getHeight (Node n, int height, int max){
        //Recursivamente obtener los datos del subárbol izquierdo
        //Recursivamente obtener los datos del subárbol derecho
        if (n.getLeft()!=null){
            height = getHeight(n.getLeft(), height+1, max);
        } else {
            height = getHeight(n.getRight(), height+1, max);
        }
        if (height>max)
            max = height;
        return height;
    }*/

    //POST ORDER Primero izq izq izq der der der imprimo
    //PRE ORDER Primero imprimo izq der
    //IN ORDER izq imprimo der

    //Recursivamente obtener los datos del subárbol izquierdo
    //Recursivamente obtener los datos del subárbol derecho
    //Imprimir el dato de la raíz
    // void printPosOrder(),

    //Imprimir el dato de la raíz
    //Recursivamente obtener los datos del subárbol izquierdo
    //Recursivamente obtener los datos del subárbol derecho
    // void printPreOrder(),

    //Recursivamente obtener los datos del subárbol izquierdo
    //Imprimir el dato de la raíz
    //Recursivamente obtener los datos del subárbol derecho
    // void printInOrder(),

    // List getLongestBranch(),
    // List getFrontera() //Hojas
    // Integer getMaxElem(),
    // List getElemAtLevel(int)
}
