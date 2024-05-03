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
        if (this.isEmpty()){
            return false;
        } else {
            return hasElem(elem, this.root);
        }
    }

    private boolean hasElem(Integer elem, Node actual){
        if (elem == actual.getKey()){
            return true;
        } else if (elem > actual.getKey() && actual.getRight()!=null){
            return hasElem(elem, actual.getRight());
        } else if (elem < actual.getKey() && actual.getLeft()!=null){
            return hasElem(elem, actual.getLeft());
        }
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

   /* public boolean delete(Integer clave) {
      return delete(clave, this.root, null);
    }

    private boolean delete(Integer clave, Node actual, Node padre){
        //busco por la izq
        if (actual.getKey() > clave) {
            if (actual.getLeft()!=null)
                return delete(clave, actual.getLeft(), actual);
            else
                return false;
        }
        //busco por la der
        else if (actual.getKey() < clave) {
            if (actual.getRight()!=null)
                return delete(clave, actual.getLeft(), actual);
            else
                return false;
        }
        //Lo encontre
        else if (actual.getKey() == clave) {
            //Es hoja
            if (actual.getLeft()==null && actual.getRight()==null && padre!=null){
               if (padre.getLeft().equals(actual))
                   padre.setLeft(null);
               else
                   padre.setRight(null);
            }
            //Tiene un hijo
            else if (actual.getLeft()!=null ^ actual.getRight()!=null){
                if (actual.getLeft()!=null)
                    padre.setLeft(actual.getLeft().getKey());
                else
                    padre.setRight(actual.getRight().getKey());
            }
            //Tiene dos hijos
            else if (actual.getLeft()!=null && actual.getRight()!=null){
                //Reemplazar con el NMI del subárbol derecho del nodo a borrar
                Node aux = actual;
                padre.setRight(getNMI(actual.getRight()));

                //Borrar el NMI del subárbol derecho
                return delete(getNMI(padre.getRight()));
            }
        }
        return true;
    }

    private Integer getNMI(Node actual){
        Node aux = actual;
        if (aux.getLeft()!=null){
            while(aux.getLeft()!=null){
                aux = aux.getLeft();
            }
        }
        return aux.getKey();
    }
*/
   public boolean delete(Integer clave) {
       return delete(clave, this.root, null);
   }

    private boolean delete(Integer clave, Node actual, Node padre) {
        if (actual == null) {
            return false; // Clave no encontrada
        }

        if (clave.compareTo(actual.getKey()) < 0) {
            return delete(clave, actual.getLeft(), actual);
        } else if (clave.compareTo(actual.getKey()) > 0) {
            return delete(clave, actual.getRight(), actual);
        } else {
            // Caso 1: Nodo hoja
            if (actual.getLeft() == null && actual.getRight() == null) {
                if (padre == null) {
                    this.root = null; // El nodo a eliminar es la raíz
                } else if (padre.getLeft() == actual) {
                    padre.setLeft(null);
                } else {
                    padre.setRight(null);
                }
            }
            // Caso 2: Nodo con un hijo
            else if (actual.getLeft() != null ^ actual.getRight() != null) {
                Node hijo = (actual.getLeft() != null) ? actual.getLeft() : actual.getRight();
                if (padre == null) {
                    this.root = hijo; // El nodo a eliminar es la raíz
                } else if (padre.getLeft() == actual) {
                    padre.setLeft(hijo.getKey());
                } else {
                    padre.setRight(hijo.getKey());
                }
            }
            // Caso 3: Nodo con dos hijos
            else {
                Node sucesor = findMin(actual.getRight());
                actual.setKey(sucesor.getKey());
                return delete(sucesor.getKey(), actual.getRight(), actual);
            }
            return true;
        }
    }

    private Node findMin(Node node) {
        while (node.getLeft() != null) {
            node = node.getLeft();
        }
        return node;
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

    public int getSuma(){
        int suma = 0;
        return getSuma(suma, this.root);
    }

    private int getSuma(int suma, Node nodo){
       //suma += 0;
       return suma;
    }


    //Ejercicio 3
    /*Dado un árbol binario de búsqueda que almacena números enteros y un valor de entrada K, implementar un
    algoritmo que permita obtener un listado con los valores de todas las hojas cuyo valor supere K.*/

    public List<Integer> getValuesK(int value){
        List<Integer> list = new ArrayList<>();
        return getValuesK(value, list, this.root);
    }

    private List<Integer> getValuesK(int value, List<Integer> list, Node n) {
        if (n != null) {
            // Si el valor del nodo actual es mayor que al value
            if (n.getKey() > value) {
                // Si es una hoja lo agrega
                if (n.getLeft() == null && n.getRight() == null)
                    list.add(n.getKey());
                // sino sigue buscando en ambos sub arboles hasta llegar a una hoja
                getValuesK(value, list, n.getLeft());
                getValuesK(value, list, n.getRight());
            }
            // Si el valor del nodo actual es menor o igual  al valor, busca solo en el subárbol derecho
            else
                getValuesK(value, list, n.getRight());
        }
        return list;
    }

    /*
        Ejercicio 4
        Se posee un árbol binario (no de búsqueda), donde los nodos internos están vacíos, mientras
        que las hojas tienen valores enteros. Se debe implementar un método que recorra el árbol y
        coloque valores en los nodos vacíos (los nodos internos). El valor de cada nodo interno debe
        ser igual al valor de su hijo derecho, menos el valor de su hijo izquierdo. En caso de que el
        nodo tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0. Por ejemplo, tomando
        como entrada el árbol de la izquierda, el árbol resultante debería quedar con los mismos
        valores que el de la derecha
    */

    public void completeTree(){
        if (!this.isEmpty())
            completeTree(this.root);
    }

    private void completeTree(Node n){
        int valueLeft = 0;
        int valueRight = 0;
        if (n.getLeft() != null)
            completeTree(n.getLeft());
        if (n.getRight() != null)
            completeTree(n.getRight());

        if (n.getKey()==999999){ // 999999 == null
            if (n.getLeft()!=null)
                valueLeft = n.getLeft().getKey();
            if (n.getRight()!=null)
                valueRight = n.getRight().getKey();
            n.setKey(valueRight-valueLeft);
        }
    }

}