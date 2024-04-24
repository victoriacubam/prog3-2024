package TP3;

public class Main {
    public static void main(String[]args){
        Tree t1 = new Tree();
        t1.insert(5);
        t1.insert(9);
        t1.insert(2);
        t1.insert(3);
        t1.insert(1);
        t1.insert(10);
        t1.insert(8);
        Tree t2 = new Tree();
        t2.insert(6);
        t2.insert(3);
        t2.insert(1);
        t2.insert(5);
        t2.insert(4);
        t2.insert(7);
        t2.insert(9);


        //Altura del arbol
        System.out.println("Altura del arbol: "+ t1.getHeight());

        //PosOrder
        t1.printPosOrder();

        //PreOrder
        t1.printPreOrder();

        //InOrder
        t1.printInOrder();

        //Max elemen
        System.out.println("Maximo elemento: " +t1.getMaxElem());
    }
}
